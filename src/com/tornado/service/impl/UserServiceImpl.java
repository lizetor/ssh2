package com.tornado.service.impl;

import com.tornado.dao.UserDao;
import com.tornado.domain.User;
import com.tornado.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void findUserByUsernameAndPassword(String username, String password) {
        userDao.findUserByUsernameAndPassword(username, password);
    }

    public User checkUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
