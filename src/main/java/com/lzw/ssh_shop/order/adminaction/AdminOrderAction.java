package com.lzw.ssh_shop.order.adminaction;

import com.lzw.ssh_shop.order.service.OrderService;
import com.lzw.ssh_shop.order.vo.Order;
import com.lzw.ssh_shop.order.vo.OrderItem;
import com.lzw.ssh_shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 后台订单管理的Action
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
    //模型驱动使用的对象
    private Order order=new Order();

    @Override
    public Order getModel() {
        return order;
    }

    //注入订单管理的Service
    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    //接收page参数
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    //带分页查询的执行方法
    public String findAll(){
        //分页查询
        PageBean<Order> pageBean=orderService.findByPage(page);
        //通过值栈保存数据到页面
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        //页面跳转
        return "findAll";
    }

    //根据订单id查询订单项
    public String findOrderItem(){
        //根据订单id查询订单项
        List<OrderItem> list=orderService.findOrderItem(order.getOid());
        //通过值栈显示到页面上
        ActionContext.getContext().getValueStack().set("list",list);
        return "findOrderItem";
    }

    //后台修改订单状态的方法
    public String updateState(){
        //1.根据订单id查询订单
        Order currOrder=orderService.findByOid(order.getOid());
        //2.修改订单状态
        currOrder.setState(3);
        orderService.update(currOrder);
        //3.页面跳转
        return "updateStateSuccess";
    }
}
