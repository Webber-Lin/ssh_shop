package com.lzw.ssh_shop.product.service;

import com.lzw.ssh_shop.product.dao.ProductDao;
import com.lzw.ssh_shop.product.vo.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品的业务层代码
 */
@Transactional
public class ProductService {
    //注入ProductDao
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    //首页上热门商品查询
    public List<Product> findHot() {
        return productDao.findHot();
    }

    //首页上最新商品的查询
    public List<Product> findNew() {
        return productDao.findNew();
    }
}
