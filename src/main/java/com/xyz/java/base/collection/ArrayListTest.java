package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试ArrayList
 */
public class ArrayListTest {

    @Test
    public void testListAdd(){
        List<String> list = new ArrayList<String>();
        ListTest.addElements(list);
        ListTest.findAllElementsTime(list);
    }

}