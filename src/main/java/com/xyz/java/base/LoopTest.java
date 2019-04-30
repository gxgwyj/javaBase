package com.xyz.java.base;

/**
 * Created by Lenovo on 2019/1/23.
 */
public class LoopTest {
    public static void main(String[] args) {
        int i = 100;
        if (i++ > 100) {
            System.out.println("i++");
        }
        System.out.println(i);
        if (++i > 100) {
            System.out.println("++i");
        }

        int b = 5;
        int d = 5;
        int c = 100+(b++);
        int e = 100+(++d);
        System.out.println(c);
        System.out.println(e);
        System.out.println(b);
        System.out.println(d);
    }
}
