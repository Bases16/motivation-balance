package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.AuthRequestDto;
import edu.arf4.motivationbalance.dto.AuthResponseDto;
import edu.arf4.motivationbalance.dto.RegisterUserDto;
import edu.arf4.motivationbalance.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthResponseDto authenticate(@RequestBody AuthRequestDto request) {
        return userService.authenticateUser(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);
    }

}
