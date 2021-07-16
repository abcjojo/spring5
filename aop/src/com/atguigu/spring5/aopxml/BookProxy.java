package com.atguigu.spring5.aopxml;


public class BookProxy {

    public void beforeBuy() {
        System.out.println("before........");
    }

    public void afterBuy() {
        System.out.println("after........");
    }
}
