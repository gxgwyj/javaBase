package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类: CollectionsUtils <br>
 * 描述: 集合工具<br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年11月27日 16:26
 */
public class CollectionsUtils {


    @Test
    public void testSort() {
        List<Integer> list = Arrays.asList(1,4,78,43,22);
        System.out.println(list.toString());
        list.sort(null);
        System.out.println(list.toString());
    }


    @Test
    public void testObjectSort() {
        Person xiaoming = new Person("明", 13);
        Person xiaozhang = new Person("张", 12);
        Person xiaogao = new Person("高", 20);
        Person xiaowang = new Person("王", 26);
        Person xiaozhao = new Person("赵", 22);

        List<Person> persons = new ArrayList<>();
        persons.add(xiaoming);
        persons.add(xiaozhang);
        persons.add(xiaogao);
        persons.add(xiaowang);
        persons.add(xiaozhao);

        System.out.println(persons.toString());

        persons.sort(new PersonComparator());

        System.out.println(persons.toString());

    }
}
