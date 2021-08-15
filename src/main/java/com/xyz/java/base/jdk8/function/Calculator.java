package com.xyz.java.base.jdk8.function;

/**
 * @author gaoxugang
 * @data 2021/8/15  12:58
 * @description 计算类
 */
public class Calculator {

    /**
     * 数学计算接口
     */
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // lambda 表达式更像是一种方法的声明
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;

        System.out.println("40 + 2 = " +
                calculator.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
                calculator.operateBinary(20, 10, subtraction));
    }
}
