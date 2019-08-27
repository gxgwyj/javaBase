package com.xyz.java.base.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author gaoxugang
 * @data 2019/8/26 0026 10:39
 * @description TODO
 */
public class CyclicBarrierAction {
    /**
     * 自定义工作线程
     */
    private static class Worker extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            super.run();
            System.out.println(Thread.currentThread().getName()+"开始等待其他线程");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"开始执行");
                Thread.sleep(1000);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            System.out.println("创建工作线程" + i);
            Worker worker = new Worker(cyclicBarrier);
            worker.start();
        }
    }
}
