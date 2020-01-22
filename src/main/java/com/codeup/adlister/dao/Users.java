package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
//    User editUser(User user);
    User getUserById(long id);
    User updateUser(User user) throws SQLException;
//    Long saveUser(User user);
    User deleteUser(User user);

}
