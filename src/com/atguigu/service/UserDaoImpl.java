package com.atguigu.service;


import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void dao() {
        System.out.println("dao add............");
    }
}
