package com.xyz.java.base.multithread.lock;

public class ThreadAction {

    public static void main(String[] args) {
        SynchronizeMethod lockObj = new SynchronizeMethod("共享锁");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程B");
                lockObj.synProcess();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程A");
                lockObj.synProcess();
            }
        }).start();


    }

}
