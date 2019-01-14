package com.xyz.java.base.variable;

/**
 * Created by Lenovo on 2019/1/14.
 */
public class CloneTest {
    public static void main(String[] args) {
        String[] names = {"张三","lisi","wangwu"};
        String[] clone = names.clone();
        System.out.println(names==clone);
        System.out.println(clone[1]="123");
        System.out.println(names==clone);

    }
}
