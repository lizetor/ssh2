package com.tornado.service.impl;

import com.tornado.dao.OrderDao;
import com.tornado.domain.Order;
import com.tornado.service.OrderService;
import com.tornado.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public PageBean<Order> findAll(Order order, int pageNum, int pageSize) {

        //拼凑查询条件
        StringBuilder builder = new StringBuilder();

        //拼凑实际参数 可以重复 顺序
        List<Object> paramsList = new ArrayList<>();

        //过滤条件
        if (StringUtils.isNotBlank(order.getMessage())) {
            builder.append(" and message like ?");
            paramsList.add("%" + order.getMessage() + "%");
        }

        //分页
        //总记录数
        int totalRecord = orderDao.getTotalRecord(builder.toString(), paramsList.toArray());
        //创建对象
        PageBean<Order> pageBean = new PageBean<>(pageNum, pageSize, totalRecord);
        //分页数据
        List<Order> data = orderDao.findAll(builder.toString(), paramsList.toArray(), pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);

        return pageBean;
    }
}
