package com.xyz.java.base.multithread.test1;

public class TestThread {
    public static void main(String[] args) {
        MyList list = new MyList();
        Thread a = new ThreadA(list);
        a.setName("a");
        Thread b = new ThreadB(list);
        b.setName("b");
        a.start();
        b.start();
    }
}
