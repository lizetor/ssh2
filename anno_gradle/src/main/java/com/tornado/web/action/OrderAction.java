package com.tornado.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tornado.domain.Order;
import com.tornado.domain.User;
import com.tornado.service.OrderService;
import com.tornado.service.UserService;
import com.tornado.utils.PageBean;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;

@Results({@Result(name = "success", location = "/message.jsp")})
public class OrderAction extends ActionSupport {

    @Resource
    private OrderService orderService;

    @Action("findOrder")
    public String register() {
        Order order = new Order();
        order.setMessage("123");
        PageBean<Order> orders = orderService.findAll(order, 2, 2);


        return SUCCESS;
    }
}
