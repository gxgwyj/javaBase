package com.xyz.java.base.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gaoxugang
 * @data 2019/8/10 0010
 * @description 模拟10个线程同时执行一个任务
 */
public class CountDownLatchBatchThread {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程[" + Thread.currentThread().getName() + "]开始等待");
                        // 最大程度的模拟并发，多个线程在准备到同一个执行点后，全部放行
                        countDownLatch.countDown();
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程[" + Thread.currentThread().getName() + "]的执行时间" + System.currentTimeMillis());
                }
            });
        }
    }


}
