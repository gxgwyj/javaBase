package com.xyz.java.base.innderClass.callBack;

/**
 * 回调
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);

        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getCallBackReference());

        caller1.go();
        caller1.go();

        caller2.go();
        caller2.go();

    }
}
