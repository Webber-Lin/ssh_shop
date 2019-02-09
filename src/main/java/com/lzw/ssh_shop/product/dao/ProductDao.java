package com.lzw.ssh_shop.product.dao;

import com.lzw.ssh_shop.product.vo.Product;
import com.lzw.ssh_shop.utils.PageHibernateCallback;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 商品持久层的代码
 */
public class ProductDao extends HibernateDaoSupport {
    //首页上热门商品查询
    public List<Product> findHot() {
        //使用离线条件查询
        DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
        //查询热门的商品，条件就是is_host=1
        criteria.add(Restrictions.eq("is_hot",1));
        //倒序排序输出
        criteria.addOrder(Order.desc("pdate"));
        //执行查询
        List<Product> list=(List<Product>)this.getHibernateTemplate().findByCriteria(criteria,0,10);
        return list;
    }

    //首页上最新商品的查询
    public List<Product> findNew() {
        //使用离线条件查询
        DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
        //按日期进行倒序降序
        criteria.addOrder(Order.desc("pdate"));
        //执行查询
        List<Product> list=(List<Product>)this.getHibernateTemplate().findByCriteria(criteria,0,10);
        return list;
    }

    //根据商品ID查询商品
    public Product findByPid(Integer pid) {
        return this.getHibernateTemplate().get(Product.class,pid);
    }

    //根据分类id查询商品的个数
    public int findCountCid(Integer cid) {
        String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
        List<Long> list=(List<Long>)this.getHibernateTemplate().find(hql,cid);
        if(list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    //根据分类id查询商品的集合
    public List<Product> findByPageCid(Integer cid, int begin, int limit) {
        String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
        //分页另一种写法
        List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{cid},begin,limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }
}