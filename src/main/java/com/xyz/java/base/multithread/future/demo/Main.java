package com.xyz.java.base.multithread.future.demo;

/**
 * @author gxg
 * @date 2021/9/2 14:55
 * @description
 */
public class Main {


    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("Hello Future!");
        System.out.println("请求完毕！");
        System.out.println("真实数据："+data.getResult());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("真实数据："+data.getResult());
    }

}
