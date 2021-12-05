package com.xyz.java.base.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gaoxugang
 * @data 2021/12/5  17:40
 * @description Callable 使用的反例
 */
public class ThreadFutureAction2{
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Future<String> future = threadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(5000L);
                    return Thread.currentThread().getName();
                }
            });
            System.out.println("提交了任务"+i);

            try {
                // 该方法会阻塞主线程，不要放到提交任务的for循环中
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            threadPool.shutdown();
        }
    }
}
