package com.xyz.java.base.classloader;

/**
 * @author Administrator
 * @data 2019/7/22
 * @description TODO
 */
public class TestJdkCl {
    public static void main(String[] args) {
        //应用程序类加载器
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("应用级类加载器：" + appClassLoader.getClass().getName());
        //应用程序类加载器的父类
        ClassLoader plaClassLoader = appClassLoader.getParent();
        System.out.println("扩展类加载器：" + plaClassLoader.getClass().getName());
        ClassLoader classLoader = TestJdkCl.class.getClassLoader();

    }
}
