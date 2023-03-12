package com.xyz.java.base.innderClass.callBack;

/**
 * 调用者
 */
public class Caller {
    private Incrementable callBackReference;

    /**
     * @param callBackReference
     */
    public Caller(Incrementable callBackReference) {
        this.callBackReference = callBackReference;
    }

    void go(){
        callBackReference.increment();
    }
}
