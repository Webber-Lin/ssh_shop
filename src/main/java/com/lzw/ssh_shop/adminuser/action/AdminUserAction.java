package com.lzw.ssh_shop.adminuser.action;

import com.lzw.ssh_shop.adminuser.service.AdminUserService;
import com.lzw.ssh_shop.adminuser.vo.AdminUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台登录的Action
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
    //模型驱动使用的对象
    private AdminUser adminUser=new AdminUser();
    @Override
    public AdminUser getModel() {
        return adminUser;
    }
    //注入Service
    private AdminUserService adminUserService;

    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }
}
