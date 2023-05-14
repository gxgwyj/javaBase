package com.xyz.java.base.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @data 2023/5/14 10:30
 * @description nio通道操作
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        writeByChannel();
        readByChannel();
    }

    public static void writeByChannel(){
        FileChannel channel = null;
        // 创建数组字节流对象
        try {
            FileOutputStream outputStream = new FileOutputStream("D:\\nio-channel.txt");

            // 获取通道
            channel = outputStream.getChannel();

            // 申请缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            for (int i = 0; i < 10; i++) {
                buffer.clear();
                buffer.put(("使用buffer和channel实现向文件中写入数据" + i + "\r\n").getBytes());
                buffer.flip();
                channel.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("数据写入文件完毕");
    }

    public static void readByChannel() throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\nio-channel.txt");

        FileChannel channel = inputStream.getChannel();

        int bufferSize = 1024 * 1024;

        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

        ByteBuffer bb = ByteBuffer.allocate(1024);

        // 读取数据到缓冲区
        int read = channel.read(buffer);

        while (read != -1) {
            // 转换为读模式
            buffer.flip();
            while (buffer.hasRemaining()){
                byte b = buffer.get();
                if (b == 10 || b == 13) {
                    bb.flip();
                    String line = Charset.forName("utf-8").decode(bb).toString();
                    System.out.println(line);
                    bb.clear();
                } else {
                    if (bb.hasRemaining()) {
                        bb.put(b);
                    }
                }
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        channel.close();
    }
}
