package com.tornado.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tornado.domain.User;
import com.tornado.service.UserService;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.annotations.Parent;

import javax.annotation.Resource;

@ParentPackage("default")
@InterceptorRefs({
        @InterceptorRef("interceptorStack1")
})
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
