package com.xyz.java.base.String;

import java.util.StringTokenizer;

/**
 * 类: StringOperate <br>
 * 描述: 字符串操作<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年03月20日 10:35
 */
public class StringOperate {

    public void operateStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            stringBuilder.append("abc");
        }
        long end = System.currentTimeMillis();

        System.out.println("StringBuilder 使用时间：" + (end - start));
    }

    public void operateStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            // StringBuffer中的append方法是同步方法，会有性能影响
            stringBuffer.append("abc");
        }
        long end = System.currentTimeMillis();

        System.out.println("StringBuffer 使用时间：" + (end - start));
    }

    public void compareStrConstant() {
        String str1 = "abcd";
        String str2 = "abcd";
        // 返回true
        System.out.println(str1 == str2);
    }

    public void testStringToken() {
        String str = "name1,name2;name1,hello,i am town";
        StringTokenizer stringTokenizer = new StringTokenizer(str,",;");
        while (stringTokenizer.hasMoreElements()) {
            System.out.println(stringTokenizer.nextElement());
        }
    }


    public static void main(String[] args) {
        String[] names = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff"};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < names.length; ++i) {
            stringBuffer.append(names[i]).append(',');
        }
        System.out.println(stringBuffer.toString());

        String name = "com.xyz.bus";
        System.out.println(name.substring(name.lastIndexOf(46) + 1));
    }


}
