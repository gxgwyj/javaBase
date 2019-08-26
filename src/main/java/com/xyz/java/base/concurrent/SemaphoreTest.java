package com.xyz.java.base.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author gaoxugang
 * @data 2019/8/26 0026 10:57
 * @description TODO
 */
public class SemaphoreTest {

    private Semaphore semaphore;

    public SemaphoreTest(int size) {
        this.semaphore = new Semaphore(size);
    }

    public void doSomething() {
        try {
            /**
             * 在 semaphore.acquire() 和 semaphore.release()之间的代码，同一时刻只允许制定个数的线程进入，
             *
             * */
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"开始任务");
            Thread.sleep(8000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SemaphoreTest action = new SemaphoreTest(3);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000 ; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    action.doSomething();
                }
            });
        }
    }
}
