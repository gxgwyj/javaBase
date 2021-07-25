package com.xyz.java.base.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gaoxugang
 * @data 2021/4/18 22:02
 * @description ServerSocket包装者
 */
public class MyServerSocket {

    private int port = 0;

    private ServerSocket server;

    /**
     * 构造一个新的服务端监听对象
     * @param port
     * @throws IOException
     */
    public MyServerSocket(int port) throws IOException {
        this.port = port;
        server = new ServerSocket(port);
    }

    public void startListenAccept() throws IOException {
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

            try {
                DataInputStream in = new DataInputStream(client.getInputStream());
                byte magic = in.readByte();
                String msg = in.readUTF();

                System.out.println("magic" + magic + "msg:" + msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
