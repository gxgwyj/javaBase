package com.xyz.java.base.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Lenovo on 2018/7/29.
 */
public class ArrayListTest {
    /**
     * 提交测试
     * @param args
     */
    public static void main(String[] args) {
//        List arrayList = new ArrayList();
//        arrayList.add("string1");
//        arrayList.add(new Date());
//        System.out.println(arrayList.toString());

//        List<String> list = new ArrayList<String>();
//        for (long i = 0; i < 2000000000; i++) {
//            list.add(i+"w");
//        }
//        System.out.println(list.size());
//        list.clear();
//        System.out.println(list.size());

//        Vector<String> vector = new Vector<String>();
//        for (int i = 0; i < 2000 ; i++) {
//            vector.add("vector"+i);
//        }
//        System.out.println(vector.toString());

        ArrayList<String> list = new ArrayList<String>();
        int i = 1;
        while (i<=10000){
            list.add("arrayList"+i);
            i++;
        }
        long start = System.currentTimeMillis();
        for (int j = 0; j <=1000 ; j++) {
            System.out.println(list.get(j));
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}