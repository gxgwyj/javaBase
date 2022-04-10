package com.xyz.java.base.multithread.future.jdk;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gaoxugang
 * @data 2022/4/9  19:03
 * @description 获取多线程执行结果的案例
 */
public class CallableDemo {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<>();

        // 开启10个线程去执行任务
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        // 获取10个线程的执行结果
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
