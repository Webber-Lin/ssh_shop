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
}
