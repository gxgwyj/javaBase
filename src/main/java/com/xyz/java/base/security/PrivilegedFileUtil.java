package com.xyz.java.base.security;

import sun.security.action.GetIntegerAction;
import sun.security.action.GetPropertyAction;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by Lenovo on 2019/1/26.
 */
public class PrivilegedFileUtil {

    /**
     * 以普通的方式创建文件
     *
     * @param fileName
     * @return
     */
    public File createFileNormal(String fileName) {
        return new File(fileName);
    }

    /**
     * 以特权的方式创建文件
     *
     * @param fileName
     * @return
     */
    public void createFilePrivileged(final String fileName) {
        AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                createFileNormal(fileName);
                return null;
            }
        });
    }

    public static void main(String[] args) {
        GetPropertyAction aTrue = new GetPropertyAction("java.rmi.server.useCodebaseOnly", "wwww");
        int handshakeTimeout = AccessController.doPrivileged(new GetIntegerAction("sun.rmi.transport.tcp.handshakeTimeout", 60000));
        String s = AccessController.doPrivileged(aTrue);
        System.out.println(s);
        System.out.println(handshakeTimeout);
    }
}
