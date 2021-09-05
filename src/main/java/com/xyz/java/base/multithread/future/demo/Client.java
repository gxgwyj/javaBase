package com.xyz.java.base.multithread.future.demo;

/**
 * @author gxg
 * @date 2021/9/2 14:51
 * @description
 */
public class Client {
    public Data request(String param) {
        FutureData futureData = new FutureData();
        new Thread(()->{
            RealData realData = new RealData(param);
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}
