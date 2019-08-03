package com.xyz.java.base.multithread.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类: ReentrantLockAction <br>
 * 描述: 可重入锁执行<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月22日 10:29
 */
public class ReentrantLockAction {



    public static void main(String[] args) {

        final SynchronizedReentrantLockMethod lock = new SynchronizedReentrantLockMethod();
       new Thread(new Runnable() {
           @Override
           public void run() {
               Thread.currentThread().setName("线程A");
               lock.synMethod1();
               lock.synMethod2();
           }
       }).start();

    }

    /**
     * 静态内部类
     */
    static class ThreadDemo implements Runnable {
        Lock lock;
        Integer id;

        public ThreadDemo(Lock lock, Integer id) {
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
            // 每个线程获取2次所
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得所的线程："+id);
                lock.unlock();
            }
        }
    }

    static class UserLocks implements Runnable{
        Lock lock1;
        Lock lock2;

        public UserLocks(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            try {
                lock1.lockInterruptibly();
                //更好的触发死锁
                TimeUnit.MILLISECONDS.sleep(10);
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock1.unlock();
                lock2.unlock();
                System.out.println(Thread.currentThread().getName()+"正常结束!");
            }

        }
    }



    /**
     * 公平锁的例子
     */
    @Test
    public void testReentrantLock2() throws InterruptedException {

        // 公平锁的定义，等待锁时间长的获取锁的机会大
        Lock lock = new ReentrantLock(true);
        for(int i=0;i<5;i++){
            new Thread(new ThreadDemo(lock,i)).start();
        }
        Thread.sleep(100000);

    }


    public void userLockMethod(Lock lock) throws InterruptedException {
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取锁");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("线程" + Thread.currentThread().getName() + "释放锁");
        lock.unlock();
    }

    @Test
    public void testUserLockMethod() {
        final Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    userLockMethod(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"th1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    userLockMethod(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"th2").start();


        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 可重入锁的测试
     */
    @Test
    public void testReentrantLock() {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("get lock");

        } catch (Exception e) {
            lock.unlock();
        }
    }


}
