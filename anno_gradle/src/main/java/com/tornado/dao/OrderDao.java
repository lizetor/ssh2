package com.tornado.dao;

import com.tornado.domain.Order;

import java.util.List;


public interface OrderDao {
    int getTotalRecord(String condition, Object[] params);

    List<Order> findAll(String condition, Object[] params, int startIndex, int pageSize);
}
