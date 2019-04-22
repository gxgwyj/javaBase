package com.xyz.java.base.multithread.threadqc;

/**
 * 类: Counter <br>
 * 描述: 计数器类<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月22日 14:40
 */
public class Counter {
    private int c = 0;

    public synchronized void increment() {
        // 分析c++操作有三个步骤
        // 1、获取c的值
        // 2、将获取到的值自增1
        // 3、将最新的值保存到变量c中
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
