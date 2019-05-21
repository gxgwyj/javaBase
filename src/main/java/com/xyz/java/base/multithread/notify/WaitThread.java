package com.xyz.java.base.multithread.notify;

/**
 * 等待线程
 */
public class WaitThread extends Thread {

    /**
     * 对象锁
     */
    private Object lock;


    public WaitThread(String name, Object lock) {
        setName(name);
        this.lock = lock;

    }


    public WaitThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+":开始" + System.currentTimeMillis());
                int i = 1+3;
                // 释放锁的点(阻塞)
                lock.wait();
                // 获取锁后开始运行的点
                System.out.println("获取锁后执行的第一个代码");
                System.out.println(i);
                System.out.println(Thread.currentThread().getName()+":结束" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
