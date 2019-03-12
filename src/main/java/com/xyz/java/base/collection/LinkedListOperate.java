package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList操作
 */
public class LinkedListOperate {

    @Test
    public void testListAdd(){

        List<String> list = new LinkedList<String>();
        ListOperate.addElements(list);
        ListOperate.findAllElementsTime(list);
    }
}
