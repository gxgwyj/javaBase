package com.xyz.java.base.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zyx
 * @date 2020/9/21 10:36
 * @description 方法执行超时时间
 */
public class InvokeTimeOut {


    public static void main(String[] args) {
        String str = getStr();
        System.out.println(str);
    }


    public static String getStr(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getResult();
            }
        });

        executor.execute(future);
        try {
            String result = future.get(1, TimeUnit.SECONDS);
            return result;
        } catch (InterruptedException e) {
            System.out.println("方法执行中断");
            future.cancel(true);
            return "a";
        } catch (ExecutionException e) {
            System.out.println("Excution异常");
            future.cancel(true);
            return "b";
        } catch (TimeoutException e) {
            System.out.println("方法执行时间超时");
            future.cancel(true);
            return "c";
        }
    }

    public static String getResult() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "abc";
    }




}
