package com.lzw.ssh_shop.category.dao;

import com.lzw.ssh_shop.category.vo.Category;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 一级分类的持久层对象
 */
public class CategoryDao extends HibernateDaoSupport {

    //Dao层的查询所有一级分类的方法
    public List<Category> findAll() {
        String hql="from Category";
        List<Category> list=(List<Category>)this.getHibernateTemplate().find(hql);
        return list;
    }
}
