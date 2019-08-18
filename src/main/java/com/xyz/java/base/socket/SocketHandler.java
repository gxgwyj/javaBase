package com.xyz.java.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author gaoxugang
 * @data 2019/8/18 0018 9:46
 * @description socket客户端连接处理器
 */
public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (true) {
                String line = in.nextLine();
                System.out.println(socket.getPort()+":"+line);

                // 向客户端输出数据
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                pw.println("hello client");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
