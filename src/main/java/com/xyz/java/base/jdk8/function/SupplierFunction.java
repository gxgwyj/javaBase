package com.xyz.java.base.jdk8.function;

import com.xyz.java.base.pojo.User;

import java.util.function.Supplier;

/**
 * @author gaoxugang
 * @data 2020/12/13  14:47
 * @description java 8 工厂函数
 */
public class SupplierFunction {
    private static Supplier<User> userSupplier = () -> new User();

    public static void main(String[] args) {
        System.out.println(userSupplier.get());
        User user = new User();
    }
}
