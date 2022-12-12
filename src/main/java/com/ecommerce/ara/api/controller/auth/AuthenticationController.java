package com.ecommerce.ara.api.controller.auth;

import com.ecommerce.ara.api.model.LoginBody;
import com.ecommerce.ara.api.model.LoginResponse;
import com.ecommerce.ara.api.model.RegistrationBody;
import com.ecommerce.ara.exception.UserAlreadyExistsException;
import com.ecommerce.ara.service.UserService;
import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {

        try {

            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        }

        catch (UserAlreadyExistsException ex) {

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {

        String jwt = userService.loginUser(loginBody);

        if (jwt == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {

            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);

            return ResponseEntity.ok(response);
        }
    }
}

