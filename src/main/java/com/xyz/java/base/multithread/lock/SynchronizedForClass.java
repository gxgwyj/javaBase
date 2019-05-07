package com.xyz.java.base.multithread.lock;

/**
 * 使用Class锁对象
 * 结论:使用synchronized 关键字修类中的静态（static）方法其实是使用Class类型的对象作为锁，类中所有被synchronized修饰的
 * 静态方法都持有相同的（Class）对象锁。
 */
public class SynchronizedForClass {

    /**
     * 对静态方法进行同步（实际上是使用Class对象作为同步锁）
     */
    public synchronized static void method1() {
        System.out.println(Thread.currentThread().getName() + "进入method1");
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开method1");
    }

    /**
     * 也是使用Class对象作为同步锁
     */
    public synchronized static void method2() {
        System.out.println(Thread.currentThread().getName() + "进入method2");
        System.out.println("method2 执行的语句");
        System.out.println(Thread.currentThread().getName() + "离开method2");

    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedForClass.method1();
            }
        },"A-t").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedForClass.method2();
            }
        },"B-t").start();
    }
}
