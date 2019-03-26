package com.xyz.java.base.pojo;

/**
 * Created by Lenovo on 2018/10/18.
 */
public class User {

    private String name;

    private String sex = "男";

    public User() {
        System.out.println("user init");
    }

    public void eat() {
        System.out.println("吃饭方法");
    }

    public String createName(String name,String sex) {
        return name+sex;
    }

    public synchronized void getMoney() {
        System.out.println("获取钱");
    }

}
