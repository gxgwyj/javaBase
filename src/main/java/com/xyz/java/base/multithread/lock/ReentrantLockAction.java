package com.xyz.java.base.multithread.lock;

/**
 * 类: ReentrantLockAction <br>
 * 描述: 可重入锁执行<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月22日 10:29
 */
public class ReentrantLockAction {



    public static void main(String[] args) {

        ReentrantLockMethod lock = new ReentrantLockMethod();
       new Thread(new Runnable() {
           @Override
           public void run() {
               Thread.currentThread().setName("线程A");
               lock.synMethod1();
               lock.synMethod2();
           }
       }).start();

    }


}
