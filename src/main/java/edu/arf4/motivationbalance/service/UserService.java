package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.UserDao;
import edu.arf4.motivationbalance.dto.AuthRequestDto;
import edu.arf4.motivationbalance.dto.AuthResponseDto;
import edu.arf4.motivationbalance.dto.RegisterUserDto;
import edu.arf4.motivationbalance.model.Employee;
import edu.arf4.motivationbalance.model.User;
import edu.arf4.motivationbalance.model.enums.Role;
import edu.arf4.motivationbalance.model.enums.UserStatus;
import edu.arf4.motivationbalance.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authManager;


    public UserService(UserDao userDao, PasswordEncoder passwordEncoder,
                       JwtTokenProvider jwtTokenProvider, AuthenticationManager authManager) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authManager = authManager;
    }

    public AuthResponseDto authenticateUser(AuthRequestDto request) {
        String username = request.getUsername();
        String password = request.getPassword();
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exists");
        }
        String token = jwtTokenProvider.createToken(username, user.getRole().name());
        return new AuthResponseDto(username, token);
    }


    @Transactional
    public void registerUser(RegisterUserDto dto) {

        if (userDao.findByUsername(dto.getUsername()) != null) {
            throw new IllegalArgumentException("user is already registered"); // TODO
        }

        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());

        User newUser = new User(employee);
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setRole(Role.SPECIALIST);
        newUser.setStatus(UserStatus.ACTIVE);

        userDao.createUser(newUser);


    }

}
