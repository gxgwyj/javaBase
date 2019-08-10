package com.xyz.java.base.multithread;

/**
 * @author Administrator
 * @data 2019/7/29
 * @description 使用volatile关键字进行打印
 */
public class ThreadPrintNumber2 {

    /**
     * volatitle 保证在多线程的环境中，各个线程对内存的可见性
     */
    static volatile int num = 0;
    static volatile boolean flag = false;

    public static void main(String[] args) {

        // 线程一
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; num < 100; ) {
                    if (!flag && (num == 0 || ++num % 2 == 0)) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "[偶数]=" + num);
                        flag = true;
                    }
                }
            }
        });
        // 线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; num < 100; ) {
                    if (flag && (++num % 2 != 0)) {

                        try {
                            // 防止打印速度过快导致混乱
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            //NO
                        }
                        System.out.println(Thread.currentThread().getName() + "[奇数]=" + num);
                        flag = false;
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}
