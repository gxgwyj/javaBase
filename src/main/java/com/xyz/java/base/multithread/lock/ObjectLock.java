package com.xyz.java.base.multithread.lock;

/**
 * 类: ObjectLock <br>
 * 描述: 使用同步语句块对锁的粒度进行改善<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月22日 15:36
 */
public class ObjectLock {
    // 该类中有两个共享变量，多个线程访问，会出现线程不安全的情况

    private long c1 = 0;
    private long c2 = 0;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    /**
     * 如果对c1和对c2的自增都是使用同步方法而不是同步块的模式，则锁的粒度较大，在有线程
     * 对c1自增时，其他对c2自增的调用必须等待，其实c1和c2的自增操作完全没有关联，可以使用不通对象的
     * 内部锁进行同步，从而提高性能。
     */

    public void inc1() {
        // 使用同步块而不是同步方法
        synchronized (lock1) {
            c1++;
        }
    }

    public void inc2() {
        // 使用同步块而不是同步方法
        synchronized (lock2) {
            c1++;
        }
    }

}
