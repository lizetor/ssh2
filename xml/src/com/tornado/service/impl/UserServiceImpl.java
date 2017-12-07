package com.tornado.service.impl;

import com.tornado.dao.UserDao;
import com.tornado.domain.User;
import com.tornado.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username, password);
    }

    public User checkUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
