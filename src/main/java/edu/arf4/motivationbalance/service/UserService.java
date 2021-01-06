package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.UserDao;
import edu.arf4.motivationbalance.dto.RegisterUserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }



    @Transactional
    public void registerUser(RegisterUserDto dto) {

        if (userDao.findByUsername(dto.getUsername()) != null) {
            throw new IllegalArgumentException(dto.getEmail()); // TODO
        }

    }

}
