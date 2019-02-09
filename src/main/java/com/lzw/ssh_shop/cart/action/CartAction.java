package com.lzw.ssh_shop.cart.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 购物车Action
 */
public class CartAction extends ActionSupport {
    //将购物项添加到购物车：执行的方法
    public String addCart(){
        return "addCart";
    }
}
