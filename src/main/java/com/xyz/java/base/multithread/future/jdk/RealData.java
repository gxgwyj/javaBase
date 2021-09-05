package com.xyz.java.base.multithread.future.jdk;

import java.util.concurrent.Callable;

/**
 * @author gxg
 * @date 2021/9/2 15:29
 * @description
 */
public class RealData implements Callable<String> {
    private String result;

    public RealData(String result) {
        this.result = result;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(result);
        Thread.sleep(5000);
        return sb.toString();
    }
}
