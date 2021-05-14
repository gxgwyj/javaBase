package com.xyz.java.base.multithread;

/**
 * @author xyz
 * @date 2021/5/14 15:19
 * @description
 */
public class UserThreadAction {

    public static void main(String[] args) {
        System.out.println(3 << 29);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        thread.start();
    }
}
