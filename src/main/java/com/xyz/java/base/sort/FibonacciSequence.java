package com.xyz.java.base.sort;

/**
 * @author Administrator
 * @data 2019/7/30
 * @description 斐波那契数列
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        // 第10个斐波那契数列
        int index = 10;

        int pre_1 = 1;
        int pre_2 = 1;
        int indexNumber = 0;

        for (int i = 2; i < index; i++) {
            indexNumber = pre_1 + pre_2;
            System.out.println(indexNumber);
            pre_2 = pre_1;
            pre_1 = indexNumber;
        }


    }
}
