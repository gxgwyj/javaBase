package com.xyz.java.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author gaoxugang
 * @data 2019/8/18
 * @description socket 服务端，该服务端只能有一个客户单端连接
 */
public class AppSocketServer {

    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(SERVER_PORT);
            // 阻塞等待客户端连接
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            Scanner in = new Scanner(inputStream);

            // 一直读取客户端数据
            while (true) {
                String line = in.nextLine();
                System.out.println("client data:" + line);

                // 向客户端输出数据
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                pw.println("hello client");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
