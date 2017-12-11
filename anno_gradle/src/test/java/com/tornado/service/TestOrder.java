package com.tornado.service;

import com.tornado.domain.Order;
import com.tornado.utils.PageBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestOrder  {
    @Autowired
    private OrderService orderService;

    @Test
    public void testService() {
        Order order = new Order();
        order.setMessage("123");
        PageBean<Order> orders = orderService.findAll(order, 2, 2);

        Assert.assertEquals(2,orders.getData().size());
    }

}