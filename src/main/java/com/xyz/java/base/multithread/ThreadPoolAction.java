package com.xyz.java.base.multithread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @data 2019/7/26
 * @description 线程池练习
 */
public class ThreadPoolAction {
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

    /**
     * 适用于并发执行大量的小任务
     */
    @Test
    public void testCachedThreadPool() {
        //创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) cachedThreadPool;
        for (int i = 0; i < 10; i++) {
            try {
                //sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 使用线程池执行任务
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()+"正在被执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println(threadPool.getActiveCount());
        }
    }

    /**
     * Fixed线程池适用于处理CPU密集型任务，确保CPU在长期被工作线程使用的情况下，尽可能的少分配线程，适用执行长期的任务
     */
    @Test
    public void testFixedThreadPool() {
        //创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName() + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        while (true) {

        }
    }


    @Test
    public void testScheduledThreadPool () {
        //创建一个可重用固定个数的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒执行");
            }
        },20,TimeUnit.SECONDS);


        while (true) {

        }

    }

    /**
     *适用于串行执行任务的场景，一个任务一个任务地执行。
     */
    @Test
    public void testSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在被执行,打印的值是:" + index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        while (true) {

        }
    }


    @Test
    public void threadPoolException() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,60,TimeUnit.SECONDS,new LinkedBlockingDeque());
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future<?> future = threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread name" + Thread.currentThread().getName());
                    Object object = null;
                    System.out.print("result## " + object.toString());
                }
            });
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        while (true) {

        }
    }

    @Test
    public void threadPoolException1() {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Object object = null;
                System.out.println(object.toString());
            }
        });
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ":" + e);
            }
        });


        executorService.execute(t);

        while (true) {

        }
    }

    @Test
    public void testExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(2000);

        ArrayList<Callable<Integer>> callers = new ArrayList<Callable<Integer>>();

        final Random rnd = new Random(System.currentTimeMillis());

        for (int i = 0; i < 100000; i++) {
            callers.add(new Callable() {
                @Override
                public Object call() throws Exception {
                    String name = Thread.currentThread().getName();
                    int num = rnd.nextInt(10);
                    Thread.sleep(1);
                    System.out.println(name + ":" + num);
                    return num;
                }
            });
        }

        try {
            executorService.invokeAll(callers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done!");
        executorService.shutdown();
    }


}
