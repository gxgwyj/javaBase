package com.xyz.java.base.operate;

import org.junit.Test;

/**
 * 类: JOperator <br>
 * 描述: java 运算符<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年03月01日 14:05
 */
public class JOperator {

    /**
    * 位移计算公式  向左移动一位相当于基数乘以2
     * 左移：n << m   n乘以2的m次方
     * 右移：n >> m
    */
    @Test
    public void leftMove() {
        int  i = 585;
        int size = 3;
        System.out.println(String.format("将%d向左位移%d位",i,size));
        System.out.println("移动前:" + Integer.toBinaryString(i));
        int result = i << size;
        System.out.println("移动后:" + Integer.toBinaryString(result));
    }

    /**
     * ^ 亦或运算  比较的两个整数，二进制位运算，相同的为0，不同的为1
     * @return
     */
    @Test
    public void orOpt() {
        int a = 809;
        int b = 809;
        System.out.println(a ^ b);
    }

    /**
     * & 符号的运算  按位(二进制)“与”运算 位置上的值都为真才为真
     * @param a   如   11111111000 & 00000000011 = 00000000000
     *  11111111000
     *  00000000011
     *  00000000000
     * @param b
     */
    @Test
    public void andOpt() {
        int a = 10;
        int b = 11;
        System.out.println(a & b);
    }

    /**
     * 无符号的右移
     * >>>:无符号右移，忽略符号位，空位都以0补齐(高位补零、低位舍弃)
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
     * 对于一个有多个数值的数组，只有一个是唯一的，其他都是成对的，怎样快速找到这个唯一值
     * 根据亦或预算符号出的一道编程题(该题就是利用java亦或运算符的操作特性)
     * 关于上边的这个结果是什么，你只需要知道异或运算的特点就可以了，
     * 比如1,2,3,2,3 ,既然异或运算满足上边的交换规则，对于1^2^3^2^3 这样的异或运算，
     * 我们换一下位置(2^2)^(3^3)^1 ，通过两个相同的数进行异或运算得到0 ,那最终就会是0^0^1 ,最后会得到1 。
     *
     */
    @Test
    public void findUniqueData() {
        int[] numarry = new int[]{8, 2, 3, 2, 3};
        int aim = numarry[0];
        for(int i = 1; i < 5; i++)
        {
            aim = aim ^ numarry[i];
        }
        System.out.println("最后："+aim);
    }


    /**
     * 总结
     * &：与运算 操作数中的位都为1，结果才为1
     */
}