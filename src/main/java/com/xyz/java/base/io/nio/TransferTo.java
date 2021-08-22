package com.xyz.java.base.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author gaoxugang
 * @data 2021/8/22  17:30
 * @description 直接通过两个通道来进行数据传输
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {

        String filePath1 = "data.txt";
        String filePath2 = "data3.txt";

        FileChannel in = null, out = null;

        try {
            in = new FileInputStream(filePath1).getChannel();
            out = new FileOutputStream(filePath2).getChannel();

            // 直接使用通道进行数据移动
            in.transferTo(0, in.size(), out);

            // 或者使用下面的方式进行数据移动
            // out.transferFrom(in, 0, in.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
