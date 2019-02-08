package com.lzw.ssh_shop.index.action;


import com.lzw.ssh_shop.category.service.CategoryService;
import com.lzw.ssh_shop.category.vo.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * 首页访问的Action
 */
public class IndexAction extends ActionSupport {
    //注入一级分类的Service
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //执行返回首页的方法
    public String execute(){
        //查询所有一级分类集合
        List<Category> cList=categoryService.findAll();
        //将一级分类存入到Session的范围
        ActionContext.getContext().getSession().put("cList",cList);
        return "index";
    }


}
