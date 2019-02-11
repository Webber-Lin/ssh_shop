package com.lzw.ssh_shop.adminuser.dao;

import com.lzw.ssh_shop.adminuser.vo.AdminUser;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 后台登录的Action
 */
public class AdminUserDao extends HibernateDaoSupport {
    //DAO中的登录的方法
    public AdminUser login(AdminUser adminUser) {
        String hql="from AdminUser where username=? and password=?";
        List<AdminUser> list= (List<AdminUser>) this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
