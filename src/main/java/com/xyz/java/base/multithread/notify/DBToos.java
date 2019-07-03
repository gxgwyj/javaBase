package com.xyz.java.base.multithread.notify;

/**
 * @author gaoxugang
 * @data 2019/7/3
 * @description 数据库工具,两个线程交替备份数据库
 */
public class DBToos {
    /**
     * 1、共享变量可见性修饰
     * 2、禁止指令重排序？
     */
    private volatile boolean prevIsA = false;

    /**
     * 线程同步方法A（备份数据库工具）
     */
    public synchronized void backupA() {

        try {
            while (prevIsA == true) {
                // 线程释放对锁对象的持有
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("******");
            }
            prevIsA = true;
            // 通知所有的线程获取锁
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 线程同步方法B（备份数据库工具）
     */
    public synchronized void backupB() {
        try {
            while (prevIsA == false) {
                // 线程释放对锁对象的持有
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("++++++");
            }
            prevIsA = false;
            // 通知所有的线程获取锁
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final DBToos dbToos = new DBToos();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dbToos.backupA();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    dbToos.backupB();
                }
            }).start();

        }
    }

}
