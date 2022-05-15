package com.xyz.java.base.multithread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaoxugang
 * @data 2022/5/15 14:07
 * @description 公平锁测试
 */
public class FairLockTest {
    /**
     * 静态内部类
     */
    static class Worker implements Runnable {
        Lock lock;
        Integer id;

        public Worker(Lock lock, Integer id) {
            this.lock = lock;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // 休眠10秒，线程阻塞
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 每个线程获取两次锁
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁的线程：" + id);
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // 公平锁的定义，等待锁时间长的获取锁的机会大
        Lock lock = new ReentrantLock(true);

        //
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(lock, i)).start();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
