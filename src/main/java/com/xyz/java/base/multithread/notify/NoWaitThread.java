package com.xyz.java.base.multithread.notify;

/**
 * @author gaoxugang
 * @data 2022/2/13 20:35
 * @description TODO
 */
public class NoWaitThread extends Thread {
    /**
     * 对象锁
     */
    private Object lock;

    public NoWaitThread(String name, Object lock) {
        setName(name);
        this.lock = lock;
    }


    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+":开始");
            System.out.println(Thread.currentThread().getName()+":结束");
        }
    }
}
