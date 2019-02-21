package com.lzw.ssh_shop.order.service;

import com.lzw.ssh_shop.order.dao.OrderDao;
import com.lzw.ssh_shop.order.vo.Order;
import com.lzw.ssh_shop.order.vo.OrderItem;
import com.lzw.ssh_shop.utils.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //我的订单的业务层的代码
    public PageBean<Order> findByPageUid(Integer uid, Integer page) {
        PageBean<Order> pageBean =new PageBean<Order>();
        //设置当前页数：
        pageBean.setPage(page);
        //设置每页显示的记录数
        Integer limit=5;
        pageBean.setLimit(limit);
        //设置总记录数
        Integer totalCount=null;
        totalCount=orderDao.findByCountUid(uid);
        pageBean.setTotalCount(totalCount);
        //设置总页数：
        Integer totalPage=null;
        if(totalCount%totalCount==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        //设置每页显示数据集合；
        Integer begin=(page-1)*limit;
        List<Order> list=orderDao.findByPageUid(uid,begin,limit);
        pageBean.setList(list);
        return pageBean;

    }

    //根据订单id查询订单
    public Order findByOid(Integer oid) {
        return orderDao.findByOid(oid);
    }

    //修改订单的操作
    public void update(Order currOrder) {
        orderDao.update(currOrder);

    }

    //业务层后台分页查询订单的方法
    public PageBean<Order> findByPage(Integer page) {
        PageBean<Order> pageBean=new PageBean<>();
        //设置当前页数
        pageBean.setPage(page);
        //设置每页显示的记录数
        int limit=10;
        pageBean.setLimit(limit);
        //设置总记录数
        int totalCount=orderDao.findByCount();
        pageBean.setTotalCount(totalCount);
        //设置总页数
        int totalPage=0;
        if(totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        //设置每页显示数据的集合
        int begin=(page-1)*limit;
        List<Order> list=orderDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    //业务层完成根据订单id查询订单项的方法
    public List<OrderItem> findOrderItem(Integer oid) {
        return orderDao.findOrderItem(oid);
    }
}
