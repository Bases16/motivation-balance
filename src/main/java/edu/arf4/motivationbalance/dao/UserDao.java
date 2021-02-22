package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.User;

public interface UserDao {
    User findByUsername(String username);
    Long createUser(User user);
    User getUserByEmpId(Long empId);
}
