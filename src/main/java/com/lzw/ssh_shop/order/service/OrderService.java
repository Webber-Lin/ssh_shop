package com.lzw.ssh_shop.order.service;

import com.lzw.ssh_shop.order.dao.OrderDao;
import com.lzw.ssh_shop.order.vo.Order;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单模块：业务层代码
 */
@Transactional
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //保存订单的业务层代码
    public void save(Order order) {
        orderDao.save(order);
    }
}
