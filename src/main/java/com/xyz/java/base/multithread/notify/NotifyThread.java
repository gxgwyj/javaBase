package com.xyz.java.base.multithread.notify;

/**
 * 通知线程
 */
public class NotifyThread extends Thread {

    private Object lock;

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
            synchronized (lock) {
                System.out.println("开始    notify time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("结束    notify time = " + System.currentTimeMillis());
                System.out.println("这段代码执行后，其他的线程才能获取锁");
            }
    }
}
