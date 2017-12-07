package com.tornado.service;

import com.tornado.domain.User;


public interface UserService {

    void save(User user);

    User findUserByUsernameAndPassword(String username, String password);

    User checkUserByUsername(String username);
}
