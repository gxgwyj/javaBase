package com.xyz.java.base.multithread;

/**
 * @author gaoxugang
 * @data 2022/1/9  17:55
 * @description 线程中断演示
 */
public class ThreadInterruptAction implements Runnable{
    @Override
    public void run() {

        System.out.println("线程"+Thread.currentThread().getName()+"开始执行");

        try {
            Thread.sleep(10*1000);

        } catch (InterruptedException e) {
            System.out.println("收到了线程中断的通知");
            System.out.println(Thread.currentThread() + " interrupted:" + Thread.interrupted());
            e.printStackTrace();
            // 获取到中断信号后，可以在catch语句中再次中断线程（原因：线程在休眠期间被中断，那么会自动清除中断信号，手动添加中断信号，中断信号依然被捕获到）
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
        }

        System.out.println("休眠后的逻辑");
        System.out.println("线程"+Thread.currentThread().getName()+"执行结束");
    }


    public static void main(String[] args) {
        ThreadInterruptAction worker = new ThreadInterruptAction();

        Thread t = new Thread(worker);
        t.start();

        // 发起线程中断指令
        t.interrupt();
    }
}
