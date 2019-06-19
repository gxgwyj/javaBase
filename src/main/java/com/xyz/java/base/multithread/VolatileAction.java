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
    }


}
