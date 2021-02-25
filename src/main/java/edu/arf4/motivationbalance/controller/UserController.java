package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.AuthRequestDto;
import edu.arf4.motivationbalance.dto.AuthResponseDto;
import edu.arf4.motivationbalance.dto.RegisterUserDto;
import edu.arf4.motivationbalance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> authenticate(@RequestBody AuthRequestDto request) {
        try {
            return ResponseEntity.ok(userService.authenticateUser(request));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password combination");
//            return new ResponseEntity<>("Invalid username/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);
    }


}
