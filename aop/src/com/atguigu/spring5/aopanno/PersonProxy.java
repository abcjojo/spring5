package com.atguigu.spring5.aopanno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 被增强的类
@Component
@Aspect
@Order(2)
public class PersonProxy {


    /**
     *  当有多个增强类对同一个方法进行增强，使用@Order注解设置优先级，数值越小，优先级越高
     */


    // 后置返回通知 有异常不执行
    @Before("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("Person Before .........");
    }
}
