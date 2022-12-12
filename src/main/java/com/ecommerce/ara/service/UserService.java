package com.ecommerce.ara.service;

import com.ecommerce.ara.api.model.LoginBody;
import com.ecommerce.ara.api.model.RegistrationBody;
import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.dao.LocalUserDAO;
import com.ecommerce.ara.exception.UserAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final LocalUserDAO localUserDAO;
    private final EncryptionService encryptionService;

    private final JWTService jwtService;

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {

            throw new UserAlreadyExistsException();
        }

        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return localUserDAO.save(user);
    }

    public String loginUser(LoginBody loginBody) {

        Optional<LocalUser> userOptional = localUserDAO.findByUsernameIgnoreCase(loginBody.getUsername());

        if (userOptional.isPresent()) {

            LocalUser user = userOptional.get();

            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {

                return jwtService.generateJWT(user);
            }
        }

        return null;
    }
}
