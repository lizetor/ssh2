package com.tornado.dao.impl;

import com.tornado.dao.UserDao;
import com.tornado.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "from User u where u.username = ? and u.password = ?";

        List users = getHibernateTemplate().find(hql, (Object[]) new String[]{username, password});

        return (User) users.get(0);
    }

    public User findUserByUsername(String username) {
        String hql = "from User u where u.username = ?";

        List users = getHibernateTemplate().find(hql, (Object[]) new String[]{username});

        if (users.size() > 0) {
            return (User) users.get(0);
        } else {
            return null;
        }
    }

}
