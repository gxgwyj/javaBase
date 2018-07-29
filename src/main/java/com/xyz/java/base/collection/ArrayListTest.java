package com.xyz.java.base.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2018/7/29.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("string1");
        arrayList.add(new Date());
        System.out.println(arrayList.toString());

    }
}
