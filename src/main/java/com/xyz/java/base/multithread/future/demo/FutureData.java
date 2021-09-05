package com.xyz.java.base.multithread.future.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gxg
 * @date 2021/9/2 10:05
 * @description
 */
public class FutureData implements Data {

    /**
     * 真实数据
     */
    private RealData realData = null;

    /**
     * 是否准备好
     */
    private boolean isReady = false;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    @Override
    public String getResult() {

        // 在数据没有准备好的时候，一直等待
        while (!isReady) {
            System.out.println("等待");
            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return realData.getResult();
    }

    public void setRealData(RealData realData) {
        lock.lock();
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        condition.signal();
        lock.unlock();
    }
}
