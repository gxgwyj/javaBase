package com.xyz.java.base.jvm;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author gaoxugang3@jd.com
 * @date 2021/11/11 23:51
 * @description 类文件解析
 */
public class ClazzFileParser {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("C:\\Users\\gaoxugang3\\Desktop\\HelloWorld.class");
        DataInputStream dis = new DataInputStream(fi);


        // 读取class文件magic
        int magic1 = dis.readUnsignedByte();
        int magic2 = dis.readUnsignedByte();
        int magic3 = dis.readUnsignedByte();
        int magic4 = dis.readUnsignedByte();

        // 使用16进制打印
        System.out.println(Integer.toHexString(magic1) + " " + Integer.toHexString(magic2) + " " + Integer.toHexString(magic3) + " " + Integer.toHexString(magic4));

        fi.close();
        dis.close();

    }
}
