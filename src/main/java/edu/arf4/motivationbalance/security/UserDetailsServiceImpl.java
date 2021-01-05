package edu.arf4.motivationbalance.security;

import edu.arf4.motivationbalance.dao.UserDao;
import edu.arf4.motivationbalance.model.User;
import edu.arf4.motivationbalance.model.enums.UserStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
//    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        return userDetailsFromUserEntity(user);
    }


    private static UserDetails userDetailsFromUserEntity(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .accountExpired(!user.getStatus().equals(UserStatus.ACTIVE))
                .credentialsExpired(!user.getStatus().equals(UserStatus.ACTIVE))
                .accountLocked(!user.getStatus().equals(UserStatus.ACTIVE))
                .disabled(!user.getStatus().equals(UserStatus.ACTIVE))
                .build();
    }
}
