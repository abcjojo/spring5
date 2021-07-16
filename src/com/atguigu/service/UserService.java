package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {

    @Value(value = "huaHeShang")
    public String name;

    @Autowired   // 默认byType
    @Qualifier(value = "userDaoImpl1")   // 和 autowired一起使用，byName
    public UserDao dao;

    @Resource
    public UserDao dao1;  /// byType

    @Resource(name = "userDaoImpl1")   // byName
    public UserDao dao2;

    public void add() {
        System.out.println("userService add ........" + name);
    }
}
