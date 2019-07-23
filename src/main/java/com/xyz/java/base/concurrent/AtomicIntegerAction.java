package com.xyz.java.base.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作类,原理CAS操作，主要设计到JAVA中的Unsafe类，将内存值和预设值（期望值）对比，如果相等，更新成想要修改的值。
 * 避免了同步锁机制
 */
public class AtomicIntegerAction {
    private static  AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(){
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        count.getAndIncrement();
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("AtomicInteger count: " + count);

    }
}
