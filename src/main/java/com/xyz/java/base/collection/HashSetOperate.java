package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 类: HashSetOperate <br>
 * 描述: HashSet中的本质是HashMap，里面存放不可重复的元素<br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年08月15日 15:22
 */
public class HashSetOperate {

    @Test
    public void testHashAdd(){

        Set<String> eles = new HashSet<String>();
        for (int i = 0; i < 20 ; i++) {
            eles.add("zhang");
        }
        System.out.println(eles.toString());
    }
}
