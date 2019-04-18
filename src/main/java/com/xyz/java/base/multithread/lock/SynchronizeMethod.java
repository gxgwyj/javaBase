package com.xyz.java.base.multithread.lock;

/**
 * 含有同步方法的类,通过执行对象的synchronized来获取【对象锁】
 * 这个对象可以看成是共享对象
 */
public class SynchronizeMethod {

    private String name;

    public SynchronizeMethod(String name) {
        this.name = name;
    }

    /**
     * 同步方法synProcess
     */
    public synchronized void  synProcess() {
        System.out.println(Thread.currentThread().getName() + "获取到了锁方法....");
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步方法
     */
    public void ansyProcess() {
        System.out.println("执行异步方法");
    }
}
