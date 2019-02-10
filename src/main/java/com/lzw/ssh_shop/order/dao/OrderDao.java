package com.lzw.ssh_shop.order.dao;

import com.lzw.ssh_shop.order.vo.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 订单模块Dao层代码
 */
public class OrderDao extends HibernateDaoSupport {

    //DAO层的保存订单的方法
    public void save(Order order) {
        this.getHibernateTemplate().save(order);
    }
}
