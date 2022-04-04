package com.xyz.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxugang
 * @data 2020/6/14 0014 14:27
 * @description -verbose:gc -Xms20M -Xmx20M -Xmn10M  -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * 使用 jdk自带的jvisualvm分析.hprof内存快照dump文件
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        new Thread(()->{
            while (true) {
                list.add(new OOMObject());
            }
        }).start();

        new Thread(()->{
            while (true) {
                list.add(new OOMObject());
            }
        }).start();

    }
}
