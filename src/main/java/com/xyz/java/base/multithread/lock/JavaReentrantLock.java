package com.xyz.java.base.multithread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaoxugang
 * @data 2019/8/26  10:26
 * @description ReentrantLock
 */
public class JavaReentrantLock {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new ThreadDemo(lock1, lock2));//该线程先获取锁1,再获取锁2
        Thread thread2 = new Thread(new ThreadDemo(lock2, lock1));//该线程先获取锁2,再获取锁1
        thread1.start();
        thread2.start();

        // 中断第一个线程
        thread1.interrupt();
    }

    /**
     * 定义任务
     */
    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;
        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }
        @Override
        public void run() {
            try {
                // 可响应中断的锁
                firstLock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"获取到锁");
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName()+"正常结束!");
            }
        }
    }
}
