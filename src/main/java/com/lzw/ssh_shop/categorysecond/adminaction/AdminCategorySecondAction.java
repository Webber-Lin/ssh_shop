package com.lzw.ssh_shop.categorysecond.adminaction;

import com.lzw.ssh_shop.category.service.CategoryService;
import com.lzw.ssh_shop.category.vo.Category;
import com.lzw.ssh_shop.categorysecond.service.CategorySecondService;
import com.lzw.ssh_shop.categorysecond.vo.CategorySecond;
import com.lzw.ssh_shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

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

    //注入一级分类的Service
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //查询二级分类的方法
    public String findAll(){
        PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
        //将PageBean的数据保存到值栈中
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findAll";
    }

    //跳转到添加页面
    public String addPage(){
        //查询所有一级分类
        List<Category> cList= categoryService.findAll();
        //把数据显示到下拉的列表中
        ActionContext.getContext().getValueStack().set("cList",cList);
        //页面跳转
        return "addPageSuccess";
    }

    //保存二级分类的方法
    public String save(){
        categorySecondService.save(categorySecond);
        return "saveSuccess";
    }

    //删除二级分类的方法
    public String delete(){
        //如果级联删除，先查询再删除，配置cascade
        categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
        categorySecondService.delete(categorySecond);
        return "deleteSuccess";
    }
}
