package com.xyz.java.base.multithread.lock;

/**
 * 线程死锁的例子
 * 例子：线程A获取到A锁，执行业务逻辑获取B,与此同时，另一个线程B获取到锁B，执行业务逻辑获取锁A，
 * 此时，陷入一场僵局，线程A不释放锁A，线程B永远获取不到锁A，线程B不释放锁B线程A永远获取不到锁B，两者一直等待....
 *
 */
public class DealThread extends Thread{
    public String userName;
    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public DealThread( String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        if ("a".equals(userName)) {
            synchronized (object1) {
                try {
                    System.out.println("userName=" + userName);
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("lock1->lock2");
                }
            }
        }

        if ("b".equals(userName)) {
            synchronized (object2) {
                try {
                    System.out.println("userName=" + userName);
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("lock2->lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DealThread t1 = new DealThread("a");
        DealThread t2 = new DealThread("b");

        t1.start();
        t2.start();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
