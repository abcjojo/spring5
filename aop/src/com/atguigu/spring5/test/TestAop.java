package com.atguigu.spring5.test;

import com.atguigu.spring5.aopanno.ProxyConfig;
import com.atguigu.spring5.aopanno.User;
import com.atguigu.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class TestAop {

    @Test
    public void test3() {
        String s = "https://item.jd.com/10032531562978.html";
        String[] split = s.split("/");
        System.out.println(Arrays.toString(split));
        System.out.println(split[2]);
        System.out.println(Objects.equals(s.split("/")[2], "item.jd.com"));


    }

    @Test
    public void test4() {
        String s = "https://item.jd.com/10032531562978.html";

        System.out.println(s.contains("item.jd.com"));


    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();

    }

    @Test
    public void test0() {
        String s = "100009563448";
        boolean b = Pattern.compile("[a-zA-Z]").matcher(s).find();
        System.out.println(b);

    }
}
