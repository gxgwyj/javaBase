package com.xyz.java.base.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author gaoxugang
 * @data 2021/4/24  22:55
 * @description 客户端
 */
public class TcpClientService {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket client = new Socket("127.0.0.1", 9001);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeByte(127);
        out.writeUTF("java transport");
        out.flush();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1001);

        out.writeUTF("java transport2");
        out.flush();

        out.close();
        client.close();
    }
}
