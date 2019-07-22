package com.xyz.java.base.multithread;

/**
 * @author gaoxugang
 * @data 2019/7/5
 * @description 线程任务
 */
public class ThreadJoinAction extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 方法join的作用：使所属的线程对象X正常执行run方法中的任务，而使得当前线程Z进行无限期的阻塞
     * 等待线程X执行销毁后再执行线程Z后面的代码，如下面的代码：
     *  threadAction线程（X）运行在main方法的主线程中（Z），threadAction（X）调用Join使得主线程（Z）一直阻塞，
     *  直到子线程（X）中的任务执行结束，才执行main主线程中的代码。
     *es_goods_spec
     * @param args
     */
    public static void main(String[] args) {
        try {
            ThreadJoinAction threadAction = new ThreadJoinAction();
            threadAction.start();
            threadAction.join();
            System.out.println("子线程已经执行完毕，执行改语句");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
