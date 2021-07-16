package com.atguigu.spring5.test;

import com.atguigu.spring5.config.TxConfig;
import com.atguigu.spring5.dao.UserDao;
import com.atguigu.spring5.dao.UserDaoImpl;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {



    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml") ;
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class) ;
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class) ;
        UserDao userDao = context.getBean("userDaoImpl", UserDaoImpl.class);
        userDao.addMoney();
    }
}
