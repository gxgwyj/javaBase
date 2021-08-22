package com.xyz.java.base.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gaoxugang
 * @data 2021/8/22  17:06
 * @description 使用通道进行文件复制
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String filePath1 = "data.txt";
        String filePath2 = "data2.txt";

        FileChannel in = null;
        FileChannel out = null;
        try {
            in = new FileInputStream(filePath1).getChannel();
            out = new FileOutputStream(filePath2).getChannel();

            // 申请缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

            // 文件复制
            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                // 清理缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
