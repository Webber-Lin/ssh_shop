package com.lzw.ssh_shop.user.service;

import com.lzw.ssh_shop.user.dao.UserDao;
import com.lzw.ssh_shop.user.vo.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户模块业务层代码
 */
@Transactional
public class UserService {
    //注入UserDao
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //按用户名查询用户的方法
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
}
