package com.xyz.java.base.io.nio;

import java.nio.ByteBuffer;

/**
 * @data 2023/5/14 9:08
 * @description Buffer操作
 */
public class BufferTest {
    public static void main(String[] args) {
        byteBufferAction();
        markAction();
    }

    public static void byteBufferAction(){
        // 在堆内存中分配缓冲区，底层为字节数组
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 使用put向缓冲区存入数据
        String data = "Java8-NioZ";
        buffer.put(data.getBytes());
        System.out.println(buffer.position());

        // 切换数据读取模式
        System.out.println("切换数据读取模式");
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst,0,dst.length));

        // 重复读 rewind 方法是将位置 position 设置为0
        System.out.println("重复读取数据");
        buffer.rewind();

        // 从指定的位置读取数据
        byte[] limitDst = new byte[buffer.limit()];
        buffer.get(limitDst);
        System.out.println(new String(limitDst,0,2));
    }

    public static void markAction(){
        // 在堆内存中分配缓冲区，底层为字节数组
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 使用put向缓冲区存入数据
        String data = "Java8-NioZ";
        buffer.put(data.getBytes());

        // 转为读模式
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        // 将前两个字节批量写入到dst中
        buffer.get(dst, 0, 2);

        // mark 方法的作用是标记当前的position
        buffer.mark();

        buffer.get(dst,2,2);
        System.out.println(buffer.position());

        // mark 方法的作用是将position恢复到mark标记的位置
        buffer.reset();

        // 清空缓冲区
        buffer.clear();

        System.out.println(buffer.position());

    }

    /**
     * 从直接内存申请缓冲区（非堆内存），非堆内存在操作IO时具有更好的性能
     * 堆内存的IO处理流程:本地IO->直接内存->非直接内存->直接内存->本地IO
     * 非堆（直接）内存IO处理流程:本地IO->直接内存->本地IO
     */
    public static void directBuffer(){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    }
}
