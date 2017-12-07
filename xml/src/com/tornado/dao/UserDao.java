package com.tornado.dao;

import com.tornado.domain.User;

public interface UserDao {

    void save(User user);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);
}
