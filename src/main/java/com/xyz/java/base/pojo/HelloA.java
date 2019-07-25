package com.xyz.java.base.pojo;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 面试题
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }
    {
        System.out.println("I'm A class");
    }
    static {
        System.out.println("static A");
    }

}
