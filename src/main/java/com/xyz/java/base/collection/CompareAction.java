package com.xyz.java.base.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author gaoxugang
 * @data 2022/9/11  15:05
 * @description java比较操作
 */
public class CompareAction  {

    /**
     * 必须实现 Comparable[可比较的]接口
     * 类的自然排序
     */
    static class Person implements Comparable<Person>{
        private String name;
        private int age;
        private String address;

        public Person(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        /**
         * 其他的Person 对象
         * @param o
         * @return
         * 思考equals方法
         */
        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static List<Person> personList = new ArrayList<Person>();

    static
    {
        personList.add(new Person("小明",20,"山西"));
        personList.add(new Person("小张",35,"山西"));
        personList.add(new Person("小华",18,"山西"));
        personList.add(new Person("小勇",22,"山西"));
        personList.add(new Person("小军",23,"山西"));
    }


    public static void main(String[] args) {
        Collections.sort(CompareAction.personList);
        CompareAction.personList.forEach(p->{
            System.out.println(p);
        });

        // 使用Comparator比较器来排序
        Collections.sort(CompareAction.personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });

        System.out.println("使用Comparator排序");
        CompareAction.personList.forEach(p->{
            System.out.println(p);
        });
    }
}
