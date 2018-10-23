package com.xyz.java.base.variable;

/**
 * 类: TryFinally <br>
 * 描述: 测试try catch finally语句以及返回的时机<br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年10月23日 16:32
 */
public class TryFinally {


    public int testMethod1() {
        int i = 100;
        try {
            return i + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            i = i + 100;
            System.out.println("finally块中的值:" + i);//finally中的值先执行，再执行return
        }
        return i;
    }

    public int testMethod2() {
        int a;
        try {
            a = 500;
            return a;
        } finally {
            a = 800;
            return a;//finally中的return 会覆盖try和catch中的值或者异常
        }
    }

    public void testMethod3() throws Exception{
        try {
            throw new Exception("自定义运行时异常");
        } finally {
            System.out.println("执行finally中的代码");//在抛出异常之前执行finally中的代码
        }
    }

    public static void main(String[] args) throws Exception {
        TryFinally ob = new TryFinally();
        System.out.println("方法testMethod1调用返回的结果:" + ob.testMethod1());
        System.out.println("方法testMethod2调用返回的结果:" + ob.testMethod2());
        ob.testMethod3();
    }

}
