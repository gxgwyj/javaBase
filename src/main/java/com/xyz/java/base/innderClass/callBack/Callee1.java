package com.xyz.java.base.innderClass.callBack;

/**
 * 被调用方1
 */
public class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}
