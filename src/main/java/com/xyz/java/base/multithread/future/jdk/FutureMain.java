package com.xyz.java.base.multithread.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author gxg
 * @date 2021/9/2 15:33
 * @description
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new RealData("Hello"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(futureTask);

        System.out.println("请求完毕！");

        try {
            Thread.sleep(2000);
            System.out.println("这里经过了一个2秒的操作！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("真实数据："+futureTask.get());

        executorService.shutdown();
    }
}
