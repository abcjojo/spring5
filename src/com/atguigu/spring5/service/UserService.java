package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;

public class UserService {


    // 创建UserDao的类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void add() {

        userDao.update();
        System.out.println("Service add ....");
    }
}
