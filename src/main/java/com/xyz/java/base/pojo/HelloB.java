package com.xyz.java.base.pojo;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description TODO
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }
    // 非静态代（动态代码块儿）码块是在每次实例化对象时被调用的,优先于构造方法中的执行
    {
        System.out.println("I'm B class");
    }

    static{
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }

    /**
     * 执行顺序：
     * 父类优先
     * 静态优先
     * 构造方法
     */

    /**
     * 输出结果输出结果：
     * static A
     * static B
     * I'm A class
     * HelloA
     * I'm B class
     * HelloB
     */

}
