package com.xyz.java.base.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2018/7/29.
 */
public class ArrayListTest {
    /**
     * 提交测试
     * @param args
     */
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("string1");
        arrayList.add(new Date());
        System.out.println(arrayList.toString());

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"w");
        }
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
    }
}