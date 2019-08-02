package com.xyz.java.base.multithread;

/**
 * @author Administrator
 * @data 2019/7/29
 * @description 面试题，多线程交替打印奇偶数
 */
public class ThreadPrintNumber1 {

    public static void main(String[] args) {

        final Object object = new Object();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "=" + (2 * i + 1));
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "=" + (2 * i + 2));
                        // 必须先通知，再等待
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });


        t1.start();
        t2.start();

    }

}
