package com.xyz.java.base.collection;

import java.util.Comparator;

/**
 * 类: PersonComparator <br>
 * 描述: <br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年11月27日 17:06
 */
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
