package com.xyz.java.base.security;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * java后门操作
 * Unsafe 是 java 留给开发者的后门，用于直接操作系统内存且不受 jvm 管辖，实现类似 C++ 风格的操作。
 * 1 用反射获取变量对象 (getDeclaredField)
 * 2 开放权限，屏蔽 private 关键字的影响 (setAccessible(true))
 * 3 调用相关方法获取到该对象中的该变量对象的内存地址 (staticFieldOffset/objectFieldOffset)
 * 4 通过内存地址去修改该对象的值 (putInt/putObject)
 * 5 获取对象的值 (getInt/getObject)
 */
public class UnsafeAction {
    public static void main(String[] args) throws Exception{
        Field staticIntField = UnsafeBean.class.getDeclaredField("staticInt");
        staticIntField.setAccessible(true);
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        // 获取静态变量的内存地址
        long staticIntAddress = unsafe.staticFieldOffset(staticIntField);
        System.out.println(staticIntAddress);
        //使用 put 方法进行值改变，需要传入其所在的 class 对象、内存地址和新的值
        unsafe.putInt(UnsafeBean.class,staticIntAddress,10);
        //使用 get 方法去获取值，需要传入其所在的 class 对象和内存地址
        int stiatcIntTest = unsafe.getInt(UnsafeBean.class,staticIntAddress);
        //此处输出为 10
        System.out.println(stiatcIntTest);

        Field staticStringField = UnsafeBean.class.getDeclaredField("staticString");
        staticStringField.setAccessible(true);
        long staticStringAddress = unsafe.staticFieldOffset(staticStringField);
        unsafe.putObject(UnsafeBean.class,staticStringAddress,"static_string_2");
        String staticStringTest = (String) unsafe.getObject(UnsafeBean.class, staticStringAddress);
        System.out.println(staticStringTest);
    }

}
