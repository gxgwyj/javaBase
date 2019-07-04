package com.xyz.java.base.multithread.lock;

/**
 * 类: SynchronizedReentrantLockMethod <br>
 * 描述: 可重入锁方法<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月22日 10:24
 */
public class SynchronizedReentrantLockMethod {

    /**
     * 同步方法1
     */
    public synchronized void synMethod1() {
        System.out.println(Thread.currentThread().getName()+"获取到锁");
        System.out.println("synMethod1");
        synMethod2();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步方法2
     */
    public synchronized void synMethod2() {
        System.out.println(Thread.currentThread().getName() + "获取到锁");
        System.out.println("synMethod2");
    }

}
