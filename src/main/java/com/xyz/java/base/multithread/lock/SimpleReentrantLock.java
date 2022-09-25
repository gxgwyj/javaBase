package com.xyz.java.base.multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaoxugang
 * @data 2022/9/25 14:37
 * @description SimpleReentrantLock
 */
public class SimpleReentrantLock {

    private static Lock lock = new ReentrantLock();

    public void doBiz(){
        // lock 操作会一直阻塞，直到其他线程释放锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":begin do biz");
            Thread.sleep(10000L);
            System.out.println(Thread.currentThread().getName() + ":finish do biz");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        SimpleReentrantLock simpleReentrantLock = new SimpleReentrantLock();

        // 模拟两个线程去掉一个业务方法
        Thread t1 = new Thread(()->{simpleReentrantLock.doBiz();});
        Thread t2 = new Thread(()->{simpleReentrantLock.doBiz();});
        t1.start();
        t2.start();

        // 调用join方法，使得主线程等待子线程执行完成再执行
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("子线程都执行完了，开始执行主线程");
    }
}
