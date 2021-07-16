package com.atguigu.spring5.testDemo;

import com.atguigu.config.SpringConfig;
import com.atguigu.demo2.collectiontype.Book;
import com.atguigu.demo2.collectiontype.Course;
import com.atguigu.demo2.collectiontype.Stu;

import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.dao.UserDao;
import com.atguigu.spring5.dao.UserDaoImpl;
import com.atguigu.spring5.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring5 {


    @Test
    public void test18() {
        // 加载配置类
        ApplicationContext cxt = new AnnotationConfigApplicationContext(SpringConfig.class);
        com.atguigu.service.UserService userService = cxt.getBean("userService", com.atguigu.service.UserService.class);
        System.out.println(userService);
        userService.dao2.dao();
    }


    @Test
    public void test17() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean10.xml");
        com.atguigu.service.UserService userService = context.getBean("userService", com.atguigu.service.UserService.class);
        System.out.println(userService);
        userService.add();
        userService.dao.dao();
        userService.dao1.dao();
        userService.dao2.dao();
    }


    @Test
    public void test16() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        com.atguigu.aotuwire.Emp emp = context.getBean("emp", com.atguigu.aotuwire.Emp.class);
        emp.printDept();
        System.out.println(emp);
    }

    @Test
    public void test15() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        com.atguigu.bean.Orders orders = context.getBean("orders", com.atguigu.bean.Orders.class);
        System.out.println("第四步：获取bean实例对象");
        System.out.println(orders);

        // 手动销毁bean实例对象
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void test14() {
        // 在Spring中bean默认是单实例对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        com.atguigu.spring5.Book book1 = context.getBean("book", com.atguigu.spring5.Book.class);
        com.atguigu.spring5.Book book2 = context.getBean("book", com.atguigu.spring5.Book.class);
        System.out.println(book1);
        System.out.println(book2);

    }

    @Test
    public void test13() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void test12() {
        BeanFactory context = new ClassPathXmlApplicationContext("bean5.xml");
        Book book = context.getBean("book", Book.class);
        book.print();
    }

    @Test
    public void test11() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Stu stu1 = context.getBean("stu1", Stu.class);
        stu1.print1();
    }

    @Test
    public void test10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.print();
    }

    @Test
    public void test9() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp2 = context.getBean("emp2", Emp.class);
        emp2.getEmpInfo();
    }

    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp1 = context.getBean("emp1", Emp.class);
        emp1.getEmpInfo();
    }

    @Test
    public void test7() {
       ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.getEmpInfo();
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserDao userService = context.getBean("userDao", UserDaoImpl.class);
        userService.update();
    }

    @Test
    public void test1() {

        // 1. 加载配置文件
        ApplicationContext content = new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        User user = content.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

//    @Test
//    public void test2() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//        Book book = context.getBean("book", Book.class);
//        book.getBookInfo();
//    }

    @Test
    public void test3() {
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders = context.getBean("orders", Orders.class);
        orders.getOrderInfo();
    }

//    @Test
//    public void test4() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//        Book book1 = context.getBean("book1", Book.class);
//        book1.getBookInfo();
//    }
}
