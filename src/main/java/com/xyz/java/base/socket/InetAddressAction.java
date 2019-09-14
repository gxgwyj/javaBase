package com.xyz.java.base.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author gaoxugang
 * @data 2019/9/14  12:00
 * @description 根据域名获取对应的主机地址
 */
public class InetAddressAction {
    public static void main(String[] args) {
        try {
            InetAddress[] inetAddress = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress address : inetAddress) {
                System.out.println(address.toString());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
