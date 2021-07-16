package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args) {

        // 创建代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl dao = new UserDaoImpl();
        UserDao o = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(dao));
        int res = o.add(1, 2);
        System.out.println("result" + res);
    }
}

// 创建代理对象
class UserDaoProxy implements InvocationHandler {

    // 获取需要被代理的类的对象
    // 通过有参构造器传递
    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }


    // 三个参数 第一个proxy：代理对象； method：方法； args：参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 方法之前增强
        System.out.println("方法之前执行   " + method.getName() + "; 传递参数" + Arrays.toString(args) + "; 代理的对象" + proxy.getClass());
        Object[] newArr = {3, 4};

        // 被增强的方法执行
        int res = (int)method.invoke(obj, newArr);

        res = res + 1;

        // 方法之后增强
        System.out.println("方法之后执行：" + obj);


        return res;
    }
}
