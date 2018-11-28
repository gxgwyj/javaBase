package com.xyz.java.base.collection;

/**
 * 类: Person <br>
 * 描述: 实体类<br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年11月27日 16:37
 */
public class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
