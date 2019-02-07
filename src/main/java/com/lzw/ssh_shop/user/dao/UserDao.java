package com.lzw.ssh_shop.user.dao;

import com.lzw.ssh_shop.user.vo.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 用户模块持久层代码：
 */
public class UserDao extends HibernateDaoSupport {
    // 按名次查询是否有该用户:
    public User findByUsername(String username){
        String hql = "from User where username = ?";
        List<User> list = (List<User>)this.getHibernateTemplate().find(hql, username);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    //注册用户存入数据库代码实现
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    //根据激活码查询用户
    public User findByCode(String code) {
        String hql="from User where code=?";
        List<User> list=(List<User>)this.getHibernateTemplate().find(hql,code);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    //修改用户状态的方法
    public void update(User existUser) {
        this.getHibernateTemplate().update(existUser);
    }
}
