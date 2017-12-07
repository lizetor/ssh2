package com.tornado.dao.impl;


import com.tornado.dao.UserDao;
import com.tornado.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "from User u where u.username = ? and u.password = ?";

        List users = getHibernateTemplate().find(hql, new String[]{username, password});

        return (User) users.get(0);
    }

    public User findUserByUsername(String username) {
        String hql = "from User u where u.username=?";

        List userList = this.getHibernateTemplate().find(hql, new String[]{username});

        if(userList.size()>0){
            return (User) userList.get(0);
        }else{
            return null;
        }
    }

}
