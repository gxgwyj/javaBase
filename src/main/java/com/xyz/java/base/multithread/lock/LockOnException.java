package com.xyz.java.base.multithread.lock;

/**
 * 类: LockOnException <br>
 * 描述: 单线程获取到锁，执行遇到异常的时候，自动释放锁<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月22日 10:40
 */
public class LockOnException {
    public static void main(String[] args) {
        // 锁
        Object lock = new Object();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程A");
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                    System.out.println("执行" + Thread.currentThread().getName() + "方法");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "异常");
                    // 一个线程在获取到同步锁之后，如果在执行方法的过程中出现异常，该线程自动释放自己所持有的锁，其他线程可以去争夺锁资源
                    throw new RuntimeException("异常");
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程B");
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                    System.out.println("执行" + Thread.currentThread().getName() + "方法");
                    System.out.println("步骤1");
                    System.out.println("步骤2");
                    System.out.println("步骤3");
                    System.out.println("正确结束");
                }
            }
        }).start();


    }
}
