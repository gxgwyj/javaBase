package com.xyz.java.base.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gaoxugang
 * @data 2019/8/18  9:41
 * @description 多客户端连接Socket服务器
 */
public class MulAppSocketServer {

    private int port;

    private ServerSocket server;

    public MulAppSocketServer(int port) {
        this.port = port;
    }

    /**
     * 启动服务其的方法
     */
    public void start() {
        try {
            server = new ServerSocket(port);
            // 不停的等待客户端连接
            while (true) {
                Socket socket = server.accept();
                SocketHandler socketHandler = new SocketHandler(socket);
                new Thread(socketHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MulAppSocketServer server = new MulAppSocketServer(5000);
        server.start();
    }
}
