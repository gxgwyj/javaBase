package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList 操作
 */
public class ArrayListOperate {

    @Test
    public void testListAdd(){
        List<String> list = new ArrayList<String>();
        ListOperate.addElements(list);
        ListOperate.findAllElementsTime(list);
    }

}