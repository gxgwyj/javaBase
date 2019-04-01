package com.xyz.java.base.multithread.notify;

/**
 * wait 方法
 * 解释：在调用wait之前，线程必须获得该对象的对象级别锁（只能在同步方法或同步块中调用wait方法），调用wait之后，释放锁
 */
public class WaitTest {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            synchronized (lock) {
                System.out.println("syn 第一行");
                lock.wait();
                System.out.println("wait 下的代码");
            }
            System.out.println("syn 下面的代码");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
