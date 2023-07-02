package com.xyz.java.base.jni;

/**
 * @author gaoxugang
 * @data 2023/7/2 15:50
 * @description jni
 */
public class TestHello {

    static {
        System.loadLibrary("JNI-Dll");
    }

    public static native void hello(String msg);

    public static void main(String[] args) {
        hello("Hello,java");
    }
}
