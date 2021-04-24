package com.xyz.java.base.socket;

import java.io.IOException;

/**
 * @author gaoxugang
 * @data 2021/4/24 22:51
 * @description TcpServer 服务
 */
public class TcpServerService {
    public static void main(String[] args) throws IOException {
        MyServerSocketWarpper socketWarpper = new MyServerSocketWarpper(9001);
        socketWarpper.startListenAccept();
    }
}
