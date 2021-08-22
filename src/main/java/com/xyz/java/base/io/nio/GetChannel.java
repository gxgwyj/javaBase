package com.xyz.java.base.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gaoxugang
 * @data 2021/8/22  16:23
 * @description java nio 通道
 *
 * 模型  应用 <-> 缓冲区 <-> 通道
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // 创建文件通道
        FileChannel fc = new FileOutputStream("data.txt").getChannel();

        // 通过 ByteBuffer 缓冲区来写入内容，跟接近于操作系统的io
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        // 打开一个文件
        //
        fc = new RandomAccessFile("data.txt", "rw").getChannel();

        // 移动到文件的最后,追加写入内容
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        // 读取文件内容
        fc = new FileInputStream("data.txt").getChannel();
        // 分配缓冲区
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        // 通道向缓冲区写入数据
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            // 从缓冲区读字节数据
            System.out.println((char) buff.get());
        }

        fc.close();

    }
}
