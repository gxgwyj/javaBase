package com.xyz.java.base.sort;

/**
 * 一个轮询算法
 */
public class LoadBalance {
    public static void main(String[] args) {
        String[] arr = new String[]{"aa","bb","cc","dd","ee"};

        for (int i = 0; ; i++) {
            int index = i % arr.length;
            System.out.println(arr[index]);
        }
    }
}
