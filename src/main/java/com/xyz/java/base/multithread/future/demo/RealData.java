package com.xyz.java.base.multithread.future.demo;

/**
 * @author gxg
 * @date 2021/9/2 10:06
 * @description 真实构造数据的场景
 */
public class RealData implements Data {

    private String result;

    public RealData(String param) {
        StringBuffer sb = new StringBuffer();
        sb.append(param);

        try {
            // 模拟构造真实数据的耗时操作
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
