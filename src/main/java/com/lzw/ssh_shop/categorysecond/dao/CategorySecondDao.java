package com.lzw.ssh_shop.categorysecond.dao;

import com.lzw.ssh_shop.categorysecond.vo.CategorySecond;
import com.lzw.ssh_shop.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 二级分类管理的Dao层
 */
public class CategorySecondDao extends HibernateDaoSupport {
    //dao层的统计二级分类的个数方法
    public int findCount() {
        String hql="select count(*) from CategorySecond";
        List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
        if(list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    //dao层分页查询二级分类的方法
    public List<CategorySecond> findByPage(int begin, int limit) {
        String hql="from CategorySecond order by csid desc";
        List<CategorySecond> list=this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql,null,begin,limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

    //dao层保存的二级分类的方法
    public void save(CategorySecond categorySecond) {
        this.getHibernateTemplate().save(categorySecond);
    }

    //Dao层的根据二级分类的id查询二级分类
    public CategorySecond findByCsid(Integer csid) {
        return this.getHibernateTemplate().get(CategorySecond.class,csid);
    }

    //Dao层的删除二级分类的方法
    public void delete(CategorySecond categorySecond) {
        this.getHibernateTemplate().delete(categorySecond);
    }

    //Dao层的修改二级分类的方法
    public void update(CategorySecond categorySecond) {
        this.getHibernateTemplate().update(categorySecond);
    }

    //dao层查询所有的方法
    public List<CategorySecond> findAll() {
        String hql="from CategorySecond";
        return (List<CategorySecond>) this.getHibernateTemplate().find(hql);

    }
}
