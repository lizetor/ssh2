package com.tornado.dao.impl;

import com.tornado.dao.OrderDao;
import com.tornado.domain.Order;
import com.tornado.utils.PageHibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from Order c where 1=1 " + condition;
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, params);
        return list.get(0).intValue();
    }


    @Override
    public List<Order> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from Order where 1=1 " + condition;
        return this.getHibernateTemplate().execute(
                new PageHibernateCallback<Order>()
                        .setHql(hql)
                        .setParams(params)
                        .setPageSize(pageSize)
                        .setStartIndex(startIndex));
    }

}
