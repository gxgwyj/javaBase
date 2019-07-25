package com.xyz.java.base.reference;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 这是一道面试题
 */
public class ReferenceCopy {
    String str = new String("good");
    char[] ch = {'a','b','c'};

    public void change(String str,char ch[]) {
        // str 引用值的一份拷贝，刚开始指向同一个内存地址，但是引用变量本事不相同，改变并不影响原来的引用变量值
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        ReferenceCopy ex = new ReferenceCopy();
        ex.change(ex.str,ex.ch);
        System.out.println("str = " + ex.str);
        System.out.println("ch = " + new String(ex.ch));
        /**
         * str = good
         * ch = gbc
         */


    }
}
