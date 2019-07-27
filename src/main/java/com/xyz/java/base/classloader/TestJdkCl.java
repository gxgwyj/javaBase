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

        // String 的类加载器打印为null，因为String使用引导类加载器，引导类加载器主要加载rt.jar下面的类，所以为空
        System.out.println(String.class.getClassLoader());

    }
}
