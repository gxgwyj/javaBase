package com.xyz.java.base.collection;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Administrator
 * @data 2019/7/31
 * @description java 中的阻塞队列
 */
public class BlockingQueueTest {

    @Test
    public void testLinkedBlockingQueue() {
        /**
         * 基于双向链表的阻塞队列
         */
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(100);
        blockingDeque.add("aaa");
        blockingDeque.add("bbb");
        blockingDeque.add("ccc");
        blockingDeque.add("ddd");

        System.out.println(blockingDeque.size());

        while (!blockingDeque.isEmpty()) {
            System.out.println(blockingDeque.remove());
        }

        System.out.println(blockingDeque.size());
    }

    @Test
    public void testArrayBlockingQueue() {
        /**
         * 基于数组的有界阻塞队列
         */
        ArrayBlockingQueue<String> blockingDeque = new ArrayBlockingQueue<>(200);
        blockingDeque.add("aaa");
        blockingDeque.add("bbb");
        blockingDeque.add("ccc");
        blockingDeque.add("ddd");

        System.out.println(blockingDeque.size());

        while (!blockingDeque.isEmpty()) {
            System.out.println(blockingDeque.poll());
        }

        System.out.println(blockingDeque.size());

    }

    /**
     * 同步队列，不存储元素，添加元素必须等到移除队列后才能成功
     */
    @Test
    public void testSynchronousQueue() {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        queue.add("aaaa");
        queue.add("bbbb");


    }
}
