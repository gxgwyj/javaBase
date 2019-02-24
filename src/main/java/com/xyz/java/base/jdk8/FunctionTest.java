package com.xyz.java.base.jdk8;

import java.util.function.Function;

/**
 * Created by Lenovo on 2019/2/23.
 */
public class FunctionTest {


    static Function<String,String> stringFunction = value->"a"+"b";

    public String functionTest(String input,Function<String,String> function) {
       return function.apply(input);
    }


    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        String input = "gaoxugang";
        String s = functionTest.functionTest(input, out -> "hello," + input);
        System.out.println(s);

        System.out.println(stringFunction.apply("abc"));


    }
}
