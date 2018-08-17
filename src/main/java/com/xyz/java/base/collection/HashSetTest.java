package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 类: HashSetTest <br>
 * 描述: <br>
 * 作者:  Administrator<br>
 * 时间: 2018年08月15日 15:22
 */
public class HashSetTest {

    @Test
    public void testHashAdd(){

        Set<String> eles = new HashSet<String>();
        for (int i = 0; i < 20 ; i++) {
            eles.add("zhang");
        }
        System.out.println(eles.toString());
    }
}
