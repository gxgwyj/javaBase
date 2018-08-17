package com.xyz.java.base.collection;

import java.text.MessageFormat;
import java.util.List;

/**
 * 类: ListTest <br>
 * 描述: <br>
 * 作者:  Administrator<br>
 * 时间: 2018年08月15日 14:30
 */
public class ListTest {

    /**
     * 测试添加50000各元素所使用的时间
     * @param list
     * @return
     */
    public static List<String> addElements(List list){

        long start = System.currentTimeMillis();
        for (long i = 0; i < 50000; i++) {
            list.add("list"+i);
        }
        long end = System.currentTimeMillis();

        System.out.println(MessageFormat.format("测试{0}添加50000元素所用时间：{1}ms",list.getClass().getSimpleName(),end-start));

        return list;
    }

    public static long findAllElementsTime(List list){

        long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(MessageFormat.format("{0}遍历{1}元素所用时间：{2}ms",list.getClass().getSimpleName(),list.size()+"",end-start));

        return end-start;
    }
}
