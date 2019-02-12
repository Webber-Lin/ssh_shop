package com.lzw.ssh_shop.category.service;

import com.lzw.ssh_shop.category.dao.CategoryDao;
import com.lzw.ssh_shop.category.vo.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 一级分类的业务层对象
 */
@Transactional
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

    //业务层保存一级分类的方法
    public void save(Category category) {
        categoryDao.save(category);
    }

    //业务层根据cid查询一级分类
    public Category findByCid(Integer cid) {
        return categoryDao.findByCid(cid);
    }

    //业务层删除一级分类的方法
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
