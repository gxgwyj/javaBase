package com.xyz.java.base.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author gaoxugang
 * @data 2021/4/24  22:55
 * @description 客户端
 */
public class TcpClientService {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 9001);
        client.getOutputStream().write(127);
    }
}
