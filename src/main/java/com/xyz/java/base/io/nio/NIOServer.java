package com.xyz.java.base.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author gaoxugang
 * @data 2023/5/21 18:06
 * @description NIO服务端
 */
public class NIOServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置非阻塞模式
            serverSocketChannel.configureBlocking(false);

            // 绑定网络服务端口
            serverSocketChannel.bind(new InetSocketAddress(8888));

            // 获取选择器
            Selector selector = Selector.open();

            // 将通道注册到选择器上，并且开始指定监听的事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            Set<SelectionKey> keys = selector.keys();

            // 轮询已经就绪的事件
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                // 开始遍历事件
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();

                    // 判断事件的类型
                    if (selectionKey.isAcceptable()){
                        System.out.println("发起连接请求");
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len;
                        while ((len = socketChannel.read(buffer)) > 0) {
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, len));
                            buffer.clear();
                        }
                    }
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
