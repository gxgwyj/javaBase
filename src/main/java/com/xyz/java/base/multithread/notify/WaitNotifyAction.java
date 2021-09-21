package com.xyz.java.base.multithread.notify;

/**
 * wait 和notify运行实例
 */
public class WaitNotifyAction {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            // wait和notify线程使用同一个对象锁
            WaitThread waitThread = new WaitThread(lock);
            NotifyThread notifyThread = new NotifyThread(lock);

            waitThread.start();
            notifyThread.start();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
