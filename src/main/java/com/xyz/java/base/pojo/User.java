package com.xyz.java.base.pojo;

/**
 * Created by Lenovo on 2018/10/18.
 */
public class User {
    private String name;

    public User() {
        System.out.println("user init");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
