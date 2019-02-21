package com.lzw.ssh_shop.order.dao;

import com.lzw.ssh_shop.order.vo.Order;
import com.lzw.ssh_shop.order.vo.OrderItem;
import com.lzw.ssh_shop.utils.PageHibernateCallback;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 订单模块Dao层代码
 */
public class OrderDao extends HibernateDaoSupport {

    //DAO层的保存订单的方法
    public void save(Order order) {
        this.getHibernateTemplate().save(order);
    }

    //DAO层我的订单的个数统计
    public Integer findByCountUid(Integer uid) {
        String hql="select count(*) from Order o where o.user.uid=?";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql,uid);
        if(list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return null;
    }

    //Dao层我的订单的查询
    public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
        String hql="from Order o where o.user.uid=? order by ordertime desc";
        List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,new Object[]{uid},begin,limit));
        return list;
    }

    //根据oid查询订单的操作
    public Order findByOid(Integer oid) {
        return this.getHibernateTemplate().get(Order.class,oid);
    }

    //修改订单的操作
    public void update(Order currOrder) {
        this.getHibernateTemplate().update(currOrder);
    }

    //Dao层统计订单个数的方法
    public int findByCount() {
        String hql="select count(*) from Order";
        List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
        if(list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    //dao层带分页的查询方法
    public List<Order> findByPage(int begin, int limit) {
        String hql="from Order order by ordertime desc";
        List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,null,begin,limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

    //Dao层的根据订单id查询订单项的方法
    public List<OrderItem> findOrderItem(Integer oid) {
        String hql="from OrderItem oi where oi.order.oid=?";
        List<OrderItem> list= (List<OrderItem>) this.getHibernateTemplate().find(hql,oid);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }
}
