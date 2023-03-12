package com.xyz.java.base.innderClass.callBack;

/**
 * 被调用方2
 */
public class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    /**
     * 内部类（闭包）
     */
    private class Closeure implements Incrementable {
        @Override
        public void increment() {
            // 内部类对它的外围类有访问权限
            Callee2.this.increment();
        }
    }

    Incrementable getCallBackReference(){
        return new Closeure();
    }

}
