package com.xyz.java.base.multithread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gaoxugang
 * @data 2021/11/28 13:26
 * @description 读写锁测试，多个线程去读：无锁，有一个线程去写：互斥
 */
public class ReadWriteLockAction {
    /**
     * 读写锁
     */
    private static ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        ReadWriteLockAction lockAction = new ReadWriteLockAction();

        // 读线程
        List<Thread> readThreadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            readThreadList.add(new Thread(new ReadWorker(lockAction),"read"+i));
        }

        // 写线程
        List<Thread> writeThreadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            writeThreadList.add(new Thread(new WriteWorker(lockAction),"write"+i));
        }

        // 开启线程
        for (int i = 0; i < readThreadList.size(); i++) {
            readThreadList.get(i).start();
        }

        // 开启线程
        for (int i = 0; i < writeThreadList.size(); i++) {
            writeThreadList.get(i).start();
        }

    }

    /**
     * 读操作
     */
    public void read() {

        Lock readLock = rwLock.readLock();

        readLock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "在进行【读】操作");
            TimeUnit.SECONDS.sleep(10);
            System.out.println(Thread.currentThread().getName() + "【读】操作结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

        readLock.unlock();
    }


    /**
     * 写操作
     */
    public void write() {

        Lock writeLock = rwLock.writeLock();

        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "在进行【写】操作");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "【写】操作结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    static class ReadWorker implements Runnable{
        private ReadWriteLockAction writeLockAction;

        public ReadWorker(ReadWriteLockAction writeLockAction) {
            this.writeLockAction = writeLockAction;
        }

        @Override
        public void run() {
            writeLockAction.read();
        }
    }

    static class WriteWorker implements Runnable{
        private ReadWriteLockAction writeLockAction;

        public WriteWorker(ReadWriteLockAction writeLockAction) {
            this.writeLockAction = writeLockAction;
        }

        @Override
        public void run() {
            writeLockAction.write();
        }
    }

}
