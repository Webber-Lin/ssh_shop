package com.lzw.ssh_shop.product.adminaction;

import com.lzw.ssh_shop.product.service.ProductService;
import com.lzw.ssh_shop.product.vo.Product;
import com.lzw.ssh_shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台商品管理的Action
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
    //模型驱动使用的对象
    private Product product=new Product();

    @Override
    public Product getModel() {
        return product;
    }

    //注入商品的Service
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //接收page参数
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    //带分页的查询商品的执行方法
    public String findAll(){
        //调用Service完成查询操作
        PageBean<Product> pageBean=productService.findByPage(page);
        //将数据传递到页面上
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        //页面跳转
        return "findAll";

    }
}
