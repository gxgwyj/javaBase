package com.xyz.java.base.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author gaoxugang
 * @data 2019/8/10 0010
 * @description TODO
 */
public class CountDownLatchAction {

    public static void main(String[] args) throws Exception{
        CountDownLatch cout = new CountDownLatch(3);

        // 任务1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1开始执行");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务1执行结束");
                cout.countDown();

            }
        }).start();

        // 任务2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2开始执行");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务2执行结束");
                cout.countDown();

            }
        }).start();


        // 任务3
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("任务3开始执行");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务3执行结束");
                cout.countDown();

            }
        }).start();
        cout.await();
        System.out.println("主线程结束");

    }
}
