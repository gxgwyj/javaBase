package com.xyz.java.base.pojo;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 父类
 */
public class People {
    String name;

    public People() {
        System.out.println(1);
    }

    public People(String name) {
        System.out.println(2);
        this.name = name;
    }
}
