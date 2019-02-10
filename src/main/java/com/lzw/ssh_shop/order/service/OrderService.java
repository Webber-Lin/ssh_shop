package com.lzw.ssh_shop.order.service;

import com.lzw.ssh_shop.order.dao.OrderDao;

/**
 * 订单模块：业务层代码
 */
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
