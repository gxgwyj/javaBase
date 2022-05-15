package com.xyz.java.base.multithread.lock;

/**
 * synchronized同步方法可重入锁
 */
public class SynchronizedReentrantLock {

    public static void main(String[] args) {

        final SynchronizedMethod lock = new SynchronizedMethod();

        // 创建线程A
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程A");
                lock.synMethod1();
                lock.synMethod2();
            }
        }).start();

        // 创建线程B
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程B");
                lock.synMethod1();
                lock.synMethod2();
            }
        }).start();

    }
}
