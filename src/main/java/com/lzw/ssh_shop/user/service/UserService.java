package com.lzw.ssh_shop.user.service;

import com.lzw.ssh_shop.user.dao.UserDao;
import com.lzw.ssh_shop.user.vo.User;
import com.lzw.ssh_shop.utils.MailUtils;
import com.lzw.ssh_shop.utils.UUIDUtils;
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

    //业务层完成用户注册代码：
    public void save(User user) {
        //将数据存入数据库
        user.setState(0);  //0:代表用户未激活. 1:代表用户已经激活
        String code= UUIDUtils.getUUID()+UUIDUtils.getUUID();
        user.setCode(code);
        userDao.save(user);
        //发送激活邮件
        MailUtils.sendMail(user.getEmail(),code);
    }

    //业务层根据激活码查询用户
    public User findByCode(String code) {
        return userDao.findByCode(code);
    }

    //修改用户的状态的方法
    public void update(User existUser) {
        userDao.update(existUser);
    }

    //用户登录的方法
    public User login(User user) {
        return userDao.login(user);
    }
}
