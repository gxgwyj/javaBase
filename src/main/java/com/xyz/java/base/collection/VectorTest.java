package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.Vector;

/**
 * 类: VectorTest <br>
 * 描述: <br>
 * 作者:  Administrator<br>
 * 时间: 2018年08月15日 14:51
 */
public class VectorTest {
    @Test
    public void testVectorAdd(){
        Vector<String> vector = new Vector<String>();
        ListTest.addElements(vector);
        ListTest.findAllElementsTime(vector);

    }
}
