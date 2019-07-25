package com.xyz.java.base.pojo;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 子类
 */
public class Child extends People{
    People father;


    public Child() {
        System.out.println(4);
    }

    public Child(String name) {
        System.out.println(3);
        this.name = name;
        father = new People(name + ":F");
    }


    public static void main(String[] args) {
        new Child("zhangsan");
    }
}
