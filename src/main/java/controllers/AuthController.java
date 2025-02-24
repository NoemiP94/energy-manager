package controllers;

import entities.User;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import payloads.user.UserDTO;
import payloads.user.UserLoginDTO;
import payloads.user.UserLoginResponseDTO;
import payloads.user.UserResponseDTO;
import services.AuthService;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body) {
        Map<String, String> authResponse = authService.authenticateUser(body);
        return new UserLoginResponseDTO(authResponse.get("token"), authResponse.get("role"));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody @Validated UserDTO newUserPayload, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException("There are errors in payload!");
        }else {
            User newUser = authService.registerUser(newUserPayload);

            return new UserResponseDTO(newUser.getUuid());
        }
    }

    @PostMapping("/register/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createAdmin(@RequestBody @Validated UserDTO newUserPayload, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException("There are errors in payload!");
        }else {
            User newUser = authService.registerAdmin(newUserPayload);

            return new UserResponseDTO(newUser.getUuid());
        }
    }
}
