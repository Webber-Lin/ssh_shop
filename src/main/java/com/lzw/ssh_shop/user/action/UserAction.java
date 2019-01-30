package com.lzw.ssh_shop.user.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块Action的类
 */
public class UserAction extends ActionSupport {

    //跳转到注册页面的执行方法
    public String registPage(){
        return "registPage";
    }
}
