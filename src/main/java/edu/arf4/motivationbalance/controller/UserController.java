package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.AuthRequestDto;
import edu.arf4.motivationbalance.dto.AuthResponseDto;
import edu.arf4.motivationbalance.dto.RegisterUserDto;
import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.service.ResultService;
import edu.arf4.motivationbalance.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/auth")
public class UserController {

    private UserService userService;
    private ResultService resultService;

    public UserController(UserService userService, ResultService resultService) {
        this.userService = userService;
        this.resultService = resultService;
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

    @GetMapping("/login")
    public String shit() {
        return "SHIT";
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }

//    @GetMapping("/3")
//    public List<ResultDto> getAllResultDtoByEmpId() {
//        return resultService.getAllResultsDtoByEmpId(3L);
//    }
}
