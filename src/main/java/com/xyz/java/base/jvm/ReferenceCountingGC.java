package com.xyz.java.base.jvm;

/**
 * @author gaoxugang
 * @data 2020/6/14  11:19
 * @description 测试类
 * -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

}
