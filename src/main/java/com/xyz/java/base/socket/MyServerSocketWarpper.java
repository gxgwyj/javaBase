package com.xyz.java.base.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gaoxugang
 * @data 2021/4/18 22:02
 * @description ServerSocket包装者
 */
public class MyServerSocketWarpper {

    private int port = 0;

    private ServerSocket server;

    /**
     * 构造一个新的服务端监听对象
     * @param port
     * @throws IOException
     */
    public MyServerSocketWarpper(int port) throws IOException {
        this.port = port;
        server = new ServerSocket(port);
    }

    public void startListenAccept() {
        if (server == null) {
            throw new RuntimeException("server instance is null error");
        }
        while (true) {
            Socket client = null;
            try {
                client = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String hostAddress = client.getInetAddress().getHostAddress();
            System.out.println("client:" + hostAddress + " accpet");
        }
    }
}
