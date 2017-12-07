package com.tornado.web.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tornado.domain.User;
import com.tornado.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;

@Results({@Result(name = "success", location = "/message.jsp")})
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    public User getModel() {
        return user;
    }

    @Resource
    private UserService userService;

    @Action("saveUser")
    public String register() {
        userService.save(user);
        return SUCCESS;
    }
}
