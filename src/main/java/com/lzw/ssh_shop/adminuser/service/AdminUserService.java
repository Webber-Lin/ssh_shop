package com.lzw.ssh_shop.adminuser.service;

import com.lzw.ssh_shop.adminuser.dao.AdminUserDao;
import com.lzw.ssh_shop.adminuser.vo.AdminUser;
import org.springframework.transaction.annotation.Transactional;

/**
 * 后台登录的业务层类
 */
@Transactional
public class AdminUserService {
    //注入Dao
    private AdminUserDao adminUserDao;

    public void setAdminUserDao(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    //业务层登录的方法
    public AdminUser login(AdminUser adminUser) {
        return adminUserDao.login(adminUser);
    }
}
