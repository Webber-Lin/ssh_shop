package com.lzw.ssh_shop.categorysecond.adminaction;

import com.lzw.ssh_shop.categorysecond.service.CategorySecondService;
import com.lzw.ssh_shop.categorysecond.vo.CategorySecond;
import com.lzw.ssh_shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台二级分类管理的Action
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
    //模型驱动使用的对象
    private CategorySecond categorySecond=new CategorySecond();
    @Override
    public CategorySecond getModel() {
        return categorySecond;
    }
    //注入二级分类Service
    private CategorySecondService categorySecondService;

    public void setCategorySecondService(CategorySecondService categorySecondService) {
        this.categorySecondService = categorySecondService;
    }
    //接收page
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    //查询二级分类的方法
    public String findAll(){
        PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
        //将PageBean的数据保存到值栈中
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findAll";
    }
}