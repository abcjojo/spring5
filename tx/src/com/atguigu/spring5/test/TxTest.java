package com.atguigu.spring5.test;

import com.atguigu.spring5.config.TxConfig;
import com.atguigu.spring5.dao.UserDao;
import com.atguigu.spring5.dao.UserDaoImpl;
import com.atguigu.spring5.entity.User;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架
@ContextConfiguration("classpath:bean1.xml")
public class TxTest {


    @Autowired
    private User user;

    @Test
    public void test9() {
        String s = "https://item.jd.com/10032531562978.html";
        String[] split = s.split("/");
        System.out.println(Arrays.toString(split));
    }

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
