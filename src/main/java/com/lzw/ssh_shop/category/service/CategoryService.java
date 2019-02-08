package com.lzw.ssh_shop.category.service;

import com.lzw.ssh_shop.category.dao.CategoryDao;
import com.lzw.ssh_shop.category.vo.Category;

import java.util.List;

/**
 * 一级分类的业务层对象
 */
public class CategoryService {
    //注入CategoryDao
    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    //业务层查询所有一级分类的方法
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
