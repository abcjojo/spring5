package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class JdbcTest {

    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Object[] o1 = {"4"};
        Object[] o2 = {"5"};
        Object[] o3 = {"6"};
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(o1);
        objects.add(o2);
        objects.add(o3);

        bookService.batchDelete(objects);
    }

    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Object[] o1 = {"java", "v", "4"};
        Object[] o2 = {"c++", "v", "5"};
        Object[] o3 = {"Mysql", "v", "6"};
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(o1);
        objects.add(o2);
        objects.add(o3);

        bookService.batchUpdate(objects);
    }


    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Object[] o1 = {"4", "java", "i"};
        Object[] o2 = {"5", "c++", "o"};
        Object[] o3 = {"6", "Mysql", "p"};
        ArrayList<Object[]> objects = new ArrayList<>();
        objects.add(o1);
        objects.add(o2);
        objects.add(o3);

        bookService.batchAdd(objects);
    }


    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.getAll());
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.getOne("1"));
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.selectCount());
    }


    @Test
    public void test0() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = Book.builder().userId("1").username("java").ustatus("a").build();
        bookService.addBook(book);
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = Book.builder().userId("1").username("python").ustatus("b").build();
        bookService.update(book);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.delete("1");
    }
}
