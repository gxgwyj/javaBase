package com.xyz.java.base.variable;

import com.xyz.java.base.pojo.User;

/**
 * Created by Lenovo on 2018/10/18.
 */
public class UserTest {
    private static User user = new User();


    public static void main(String[] args) {
        User user1 = new User();
        System.out.println(user1.hashCode());
        user1.setName("james");
        System.out.println(user1.hashCode());
    }
}
