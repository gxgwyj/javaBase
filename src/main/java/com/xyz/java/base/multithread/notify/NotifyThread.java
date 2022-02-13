package com.xyz.java.base.multithread.notify;

import java.util.List;

/**
 * 通知线程
 */
public class NotifyThread extends Thread {

    private List<Thread> otherList;

    /**
     * 对象锁
     */
    private Object lock;

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }

    public void setOtherList(List<Thread> otherList) {
        this.otherList = otherList;
    }

    @Override
    public void run() {
            synchronized (lock) {
                // 又开启一个线程
                for (Thread ot:otherList) {
                    ot.start();
                }
                System.out.println("开始    notify time = " + System.currentTimeMillis());

                // 调用notify后，线程并没有释放锁，只是通知其他线程做好获取锁的准备，
                // 即改变线程的状态，只有线程离开该同步方法后才，才释放了对象锁。
                lock.notifyAll();

                System.out.println("结束    notify time = " + System.currentTimeMillis());
            }
    }
}
