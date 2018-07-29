package com.xyz.java.base.collection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lenovo on 2018/7/29.
 */
public class LinkedListTest {
    public static void main(String[] args) throws Exception{
        List<String> list = new LinkedList<String>();
        list.add("xyzabc");
        list.add("test");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(list));
    }
}
