package com.xyz.java.base.reference;

/**
 * 类: Pass <br>
 * 描述: <br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年02月25日 16:10
 */
public class Pass {
    public static void test(StringBuffer str) {
        str = new StringBuffer("World");  //   = 赋值，而不是 append 操作
    }

    public static void main(String[] args) {
        StringBuffer string = new StringBuffer("Hello");
        System.out.println(string);
        test(string);
        System.out.println(string);  // what is it now ?
    }
}
