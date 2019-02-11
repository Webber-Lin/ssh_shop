package com.lzw.ssh_shop.category.adminaction;

import com.lzw.ssh_shop.category.service.CategoryService;
import com.lzw.ssh_shop.category.vo.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 后台一级分类管理的Action
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
    //模型驱动使用的类
    private Category category=new Category();
    @Override
    public Category getModel() {
        return category;
    }

    //注入一级分类的Service
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //后台执行查询所有一节分类的方法
    public  String findAll(){
        //查询所有一级分类
        List<Category> cList=categoryService.findAll();
        //将集合的数据显示到页面：
        ActionContext.getContext().getValueStack().set("cList",cList);
        return "findAll";
    }
}
