package com.lzw.ssh_shop.product.adminaction;

import com.lzw.ssh_shop.categorysecond.service.CategorySecondService;
import com.lzw.ssh_shop.categorysecond.vo.CategorySecond;
import com.lzw.ssh_shop.product.service.ProductService;
import com.lzw.ssh_shop.product.vo.Product;
import com.lzw.ssh_shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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

    //注入二级分类的Service
    private CategorySecondService categorySecondService;

    public void setCategorySecondService(CategorySecondService categorySecondService) {
        this.categorySecondService = categorySecondService;
    }

    //接收page参数
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    //文件上传需要的参数
    private File upload; //上传的文件
    private String uploadFileName; //接收文件上传的文件名
    private String uploadContextType; //接收文件上传的文件的MIME的类型

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUploadContextType(String uploadContextType) {
        this.uploadContextType = uploadContextType;
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

    //跳转到添加页面的方法
    public String addPage(){
        //查询所有二级分类的集合
        List<CategorySecond> cslist= categorySecondService.findAll();
        //通过值栈进行保存数据
        ActionContext.getContext().getValueStack().set("csList",cslist);
        //页面跳转:
        return "addPageSuccess";
    }

    //保存商品的方法
    public String save() throws IOException {
        //调用Service完成保存的操作
        product.setPdate(new Date());
        if(upload!=null){
            //获得文件上传的磁盘绝对路径
            String realPath=ServletActionContext.getServletContext().getRealPath("/products");
            //创建一个文件
            File diskFile=new File(realPath+"//"+uploadFileName);
            //文件上传
            FileUtils.copyFile(upload,diskFile);
            product.setImage("products/"+uploadFileName);
        }
        //将数据保存到数据库
        productService.save(product);
        return "saveSuccess";
    }
}
