package com.xyz.java.base.collection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lenovo on 2018/7/29.
 */
public class LinkedListTest {
    public static void main(String[] args) throws Exception{
//        List<String> list = new LinkedList<String>();
//        list.add("xyzabc");
//        list.add("test");
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(list));

        LinkedList<String> list = new LinkedList<String>();
        int i = 1;
        while (i<=10000){
            list.add("linkedList"+i);
            i++;
        }
        long start = System.currentTimeMillis();
//        for (int j = 0; j <=1000 ; j++) {
//            System.out.println(list.get(j));
//        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
