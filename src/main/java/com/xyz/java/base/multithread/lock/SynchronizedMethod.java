package com.xyz.java.base.multithread.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedMethod {

    /**
     * 定义可重入锁
     */
    private static Lock lock = new ReentrantLock();

    /**
     * 一个JVM里面所有的方法同步访问
     */
    public void methodWithLock(){
        lock.lock();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /**
     * 同步方法1
     */
    public synchronized void synMethod1() {
        System.out.println(Thread.currentThread().getName() + "获取到锁，执行synMethod1方法");
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
        System.out.println(Thread.currentThread().getName() + "获取到锁，执行synMethod2方法");
    }

}
