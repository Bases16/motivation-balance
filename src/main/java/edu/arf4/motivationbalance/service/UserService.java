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

    @Transactional(readOnly = true)
    public AuthResponseDto authenticateUser(AuthRequestDto request) {
        String email = request.getEmail();
        String password = request.getPassword();
        User user = userDao.findByUsername(email);
        authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Employee employee = user.getEmployee();
        Long empId = employee != null ? employee.getId() : null;

        String token = jwtTokenProvider.createToken(email, user.getRole().name());
        return new AuthResponseDto(empId, email, token);
    }

    @Transactional
    public void registerUser(RegisterUserDto dto) {
        if (userDao.findByUsername(dto.getEmail()) != null) {
            throw new IllegalArgumentException("EMAIL_EXISTS");
        }
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmpRole(Role.SPECIALIST);

        User newUser = new User(employee);
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setRole(Role.SPECIALIST);
        newUser.setStatus(UserStatus.ACTIVE);

        userDao.createUser(newUser);
    }

}
