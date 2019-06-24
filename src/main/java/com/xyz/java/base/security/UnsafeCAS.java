package com.xyz.java.base.security;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeCAS {
    public static void main(String[] args) throws Exception{

        Integer i = 1;
        Field valueField = Integer.class.getDeclaredField("value");
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        valueField.setAccessible(true);
        long valueAddress = unsafe.objectFieldOffset(valueField);

        //该方法用户比较及替换值
        //第一个参数为要替换的对象本身，第二个参数为值的内存地址
        //第三个参数为变量的预期值，第四个参数为变量要换的值
        //如果变量目前的值等于预期值(第三个参数)，则会将变量的值换成新值(第四个参数)，返回 true
        //如果不等于预期，则不会改变，并返回 false
        boolean isOk = unsafe.compareAndSwapInt(i,valueAddress,1,5);
        //此处输出 true
        System.out.println(isOk);
        //此处输出 5
        System.out.println(i);
    }
}
