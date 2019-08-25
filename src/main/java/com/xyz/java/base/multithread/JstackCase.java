package com.xyz.java.base.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author gaoxugang
 * @data 2019/8/25 0025 9:27
 * @description jstack 工具测试
 */
public class JstackCase {
    public static Executor executor = Executors.newFixedThreadPool(5);
    public static Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        executor.execute(task1);
        executor.execute(task2);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                calculate();
            }
        }

        private void calculate() {
            int i = 0;
            while (true) {
                i++;
            }
        }
    }
}

