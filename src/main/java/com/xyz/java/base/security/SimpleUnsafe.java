package com.xyz.java.base.security;

import com.xyz.java.base.jdk8.function.Person;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.time.LocalDate;

/**
 * @author gaoxugang
 * @data 2023/10/5 21:00
 * @description Unsafe操作类
 */
public class SimpleUnsafe {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        Person person = new Person("gaoxugang3", LocalDate.MAX, Person.Sex.MALE,"498868779@qq.com");

        int anInt = unsafe.getInt(person, 16L);
        System.out.println(anInt);

        long anLong = unsafe.getLong(person, 16L);
        System.out.println(anLong);

    }
}
