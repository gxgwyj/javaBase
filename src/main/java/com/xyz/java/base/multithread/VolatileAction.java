package com.xyz.java.base.multithread;

import java.util.UUID;

/**
 * volatile 关键字的
 * 作用：解决多线程对共享变量的可见性，但是并不能保证原子操作
 */
public class VolatileAction {

    private volatile String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public static void main(String[] args) {

        final VolatileAction action = new VolatileAction();
        action.setName("start");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" + action.getName());
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    action.setName(UUID.randomUUID().toString());
                }
            }
        },"B").start();


        codeReordering();

    }

    /**
     * 指令重排序解释
     */
    public static void codeReordering() {
        int x, y;
        x = 1;
        try {
            /**
             * y = 0 / 0可能会被重排序在x = 2之前执行，为了保证最终不致于输出x = 1的错误结果，
             * JIT在重排序时会在catch语句中插入错误补偿代码，将x赋值为2，将程序恢复到发生异常时应有的状态。
             * 这种做法的确将异常捕捉的逻辑变得复杂了，但是JIT的优化的原则是，尽力优化正常运行下的代码逻辑，
             * 哪怕以catch块逻辑变得复杂为代价，毕竟，进入catch块内是一种“异常”情况的表现。
             */
            //
            x = 2;
            y = 0 / 0;
        } catch (Exception e) {
            /**
             * 此处JIT在重排序中插入错误补偿代码将x赋值为2
             */
        } finally {
            System.out.println("x = " + x);
        }

    }


}
