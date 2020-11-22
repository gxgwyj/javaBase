package com.xyz.java.base.jdk8.function;

import java.util.function.Function;

/**
 * @author gaoxugang
 * @data 2020/11/21 23:32
 * @description java function 函数
 */
public class FunctionTest {
    public static void main(String[] args) {
        // 定义函数
        Function<String, String> function = (param) -> {
            return "hello " + param;
        };

        // 等价于
        Function<String,String> functionInterface = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "hello world";
            };
        };

        // 执行函数
        String result = function.apply("java");
        System.out.println(result);
    }
}
