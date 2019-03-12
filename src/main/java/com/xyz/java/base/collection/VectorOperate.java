package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.Vector;

/**
 * 类: VectorOperate <br>
 * 描述: <br>
 * 作者:  Administrator<br>
 * 时间: 2018年08月15日 14:51
 */
public class VectorOperate {
    @Test
    public void testVectorAdd(){
        Vector<String> vector = new Vector<String>();
        ListOperate.addElements(vector);
        ListOperate.findAllElementsTime(vector);

    }
}
