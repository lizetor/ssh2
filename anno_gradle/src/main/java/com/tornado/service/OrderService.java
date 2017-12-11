package com.tornado.service;

import com.tornado.domain.Order;
import com.tornado.utils.PageBean;

/**
 * Created by Ethan on 2017/12/11.
 */
public interface OrderService {
    PageBean<Order> findAll(Order order, int pageNum, int pageSize);
}
