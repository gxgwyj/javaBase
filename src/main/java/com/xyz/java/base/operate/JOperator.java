package com.xyz.java.base.operate;

import org.junit.Test;

/**
 * 类: JOperator <br>
 * 描述: java 运算符<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年03月01日 14:05
 */
public class JOperator {

    public static void main(String[] args) {
    }

    /**
    * 位移计算公式  向左移动一位相当于基数乘以2
     * 左移：n << m   n乘以2的m次方
     * 右移：n >> m
    */
    public static int leftMove(int i ,int size) {
        System.out.println(String.format("将%d向左位移%d位",i,size));
        System.out.println("移动前:" + Integer.toBinaryString(i));
        int result = i << size;
        System.out.println("移动后:" + Integer.toBinaryString(result));
        return result;
    }

    /**
     * ^ 亦或运算  比较的两个整数，二进制位运算，相同的为0，不同的为1
     * @param a
     * @param b
     * @return
     */
    public static int orOpt(int a, int b) {
        return a ^ b;
    }

    /**
     * & 符号的运算  按位(二进制)“与”运算 位置上的值都为真才为真
     * @param a   如   11111111000 & 00000000011 = 00000000000
     *  11111111000
     *  00000000011
     *  00000000000
     * @param b
     */
    public static int andOpt(int a, int b) {
        return a & b;
    }

    /**
     * 无符号的右移
     * >>>:无符号右移，忽略符号位，空位都以0补齐
     * 1111111 11111111 11111111 11111111
     *
     */
    @Test
    public void noSymbolRightMove() {
        int a = Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(a >>> 16));
    }

    /**
     * 首先，假设有一种情况，
     * 对象 A.hashCode = 1000010001110001000001111000000
     * 对象 B.hashCode = 0111011100111000101000010100000
     */
}