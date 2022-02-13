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
                System.out.println(Thread.currentThread().getName()+":开始" + System.currentTimeMillis());
                // 释放锁的点(阻塞)，调用wait方法后，其他线程可以获取到锁
                lock.wait();
                // 被通知后开始运行的点
                System.out.println(Thread.currentThread().getName() + "：wait后继续执行");
                System.out.println(Thread.currentThread().getName()+":结束" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
