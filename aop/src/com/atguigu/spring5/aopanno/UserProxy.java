package com.atguigu.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 增强类
@Component
@Aspect     // 生成代理对象
@Order(1)
public class UserProxy {


    // 抽取相同切入点
    @Pointcut(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void pointCut() {

    }

    /**
     * 前置通知
     *  切入点表达式：  execution([权限修饰符] [返回类型] [类的全路径] [方法名称] ([参数列表])])
     *                  权限修饰符可省略  *-匹配所有返回类型   *-路径下所有类  *-类中的所有方法  。。-表示所有参数列表
     */
//    @Before(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    @Before("pointCut()")
    public void before() {
        System.out.println("before..........");
    }

    // 最终通知 一定会通知
    @After("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after.........");
    }


    // 后置返回通知 有异常不执行
    @AfterReturning("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    // 异常通知 有异常才会执行 在after最终通知后执行
    @AfterThrowing("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }


    // 环绕通知
    @Around("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        // 有异常不执行
        System.out.println("环绕之后.........");
    }
}
