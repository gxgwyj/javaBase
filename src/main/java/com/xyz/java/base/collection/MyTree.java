package com.xyz.java.base.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 二叉树元素
 */
public class MyTree {
    public  String data;
    public  MyTree left;
    public  MyTree right;

    public static void main(String[] args) {
        int sshift = 0;
        int ssize = 1;
        int concurrencyLevel = 15;
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }

        System.out.println(sshift);
        System.out.println(ssize);

    }
}
