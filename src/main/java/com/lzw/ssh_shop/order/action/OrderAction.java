package com.lzw.ssh_shop.order.action;

import com.lzw.ssh_shop.order.service.OrderService;
import com.lzw.ssh_shop.order.vo.Order;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 订单管理的Action
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
    //模型驱动使用的对象
    private Order order=new Order();
    //注入OrderService
    private OrderService orderService;
    @Override
    public Order getModel() {
        return order;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
