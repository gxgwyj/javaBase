package com.xyz.java.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

/**
 * @author gaoxugang
 * @data 2020/8/1  23:06
 * @description io 工具
 */
public class IOUtils {

    /**
     * 获得一个文件的大小
     * @param absolutePath 文件的绝对路径
     * @return 单位：byte = 8bit
     */
    public static long readFileSize(String absolutePath) {
        File file = new File(absolutePath);
        return file.length();
    }

    public static int read(InputStream in) throws IOException {
        return in.read();
    }


    /**
     * 对象序列化
     * @param out
     * @param obj
     * @throws IOException
     */
    public static void  writeObject(ObjectOutputStream out, Object obj) throws IOException {
        out.writeObject(obj);
    }

    public static void main(String[] args) throws IOException{
        String absolutePath = "E:\\高旭刚\\学习资料\\图书\\JAVA语言\\TCPIP入门经典第5版_12997313 (1).pdf";
        System.out.println(IOUtils.readFileSize(absolutePath));

        InputStream in = new FileInputStream(absolutePath);
        long size = 0;
        int val;
        // 按一个字节的方法读取文件效率极低
        do {
            val = IOUtils.read(in);
            if (val != -1) {
                size++;
            }
        }while (val!=-1);
        System.out.println(size);
    }


}
