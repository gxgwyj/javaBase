package com.xyz.java.base.jdk8.function;

import java.util.function.Consumer;

/**
 * @author gaoxugang
 * @data 2021/8/15  13:53
 * @description lambda作用域
 */
public class LambdaScopeTest {

    public int x = 0;

    class FirstLevel  {

        public int x = 1;

        void methodInFirstLevel(int x) {

            int z = 2;

            // 定义lambda 函数
            Consumer<Integer> myConsumer = (y) ->{
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " +
                        LambdaScopeTest.this.x);
            };
            myConsumer.accept(x);
        }
    }

    public static void main(String[] args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel  fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
