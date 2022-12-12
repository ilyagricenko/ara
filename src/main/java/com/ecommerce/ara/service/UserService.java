package com.ecommerce.ara.service;

import com.ecommerce.ara.api.model.RegistrationBody;
import com.ecommerce.ara.domain.LocalUser;
import com.ecommerce.ara.domain.dao.LocalUserDAO;
import com.ecommerce.ara.exception.UserAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final LocalUserDAO localUserDAO;

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
        //Encrypt password
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);
    }
}
