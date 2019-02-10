package com.lzw.ssh_shop.order.action;

import com.lzw.ssh_shop.cart.vo.Cart;
import com.lzw.ssh_shop.cart.vo.CartItem;
import com.lzw.ssh_shop.order.service.OrderService;
import com.lzw.ssh_shop.order.vo.Order;
import com.lzw.ssh_shop.order.vo.OrderItem;
import com.lzw.ssh_shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.Date;

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

    //生成订单的方法
    public String save(){
        //1.保存数据到数据库
        //订单数据补全
        order.setOrdertime(new Date());
        order.setState(1);  //1.未付款 2.已经付款，但是没有发货 3.已经发货，但是没有确认收货 4.交易完成
        //总计的数据是购物车中信息
        Cart cart=(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
        if(cart==null){
            this.addActionError("亲！您还没有购物！请先去购物！");
            return "msg";
        }
        order.setTotal(cart.getTotal());
        //设置订单中的订单项
        for(CartItem cartItem:cart.getCartItems()){
            OrderItem orderItem=new OrderItem();
            orderItem.setCount(cartItem.getCount());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);

            order.getOrderItems().add(orderItem);
        }
        //设置订单所属的用户
        User existUser=(User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
        if(existUser==null){
            this.addActionError("亲！您还没有登录！请先去登录！");
            return "login";
        }
        order.setUser(existUser);
        orderService.save(order);
        //2.将订单对象显示到页面上
        return "saveSuccess";
    }
}
