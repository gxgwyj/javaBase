package com.xyz.java.base.multithread;

/**
 * @author Administrator
 * @data 2019/7/29
 * @description 面试题，多线程交替打印奇偶数
 */
public class ThreadPrintNumber1 {

    public static void main(String[] args) {

        /**
         * 共享锁
         */
        final Object lock = new Object();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "=" + (2 * i + 1));
                        // 调用notify之后并没有释放锁，只是通知其他线程做好获取锁的准备，该方法执行完成之后才会释放锁操作
                        lock.notify();
                        try {
                            // wait释放锁操作
                            lock.wait();
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
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "=" + (2 * i + 2));
                        // 必须先通知，再等待
                        lock.notify();
                        try {
                            lock.wait();
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
