package com.xyz.java.base.jdk7.classloader;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 子类
 */
public class Child {


    public Child() {
        System.out.println(4);
    }

    public Child(String name) {
        System.out.println(3);
    }


    public static void main(String[] args) {
        new Child("zhangsan");
    }
}
