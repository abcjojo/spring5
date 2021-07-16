package com.atguigu.bean;

public class Orders {

    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步：调用set方法设置属性值");
    }

    public Orders() {
        System.out.println("第一步：无参构造器创建bean实例");
    }

    public void initMethod() {
        System.out.println("第三步：执行初始化方法");
    }

    public void destroyMethod() {
        System.out.println("第五步：销毁bean实例对象的方法");
    }
}
