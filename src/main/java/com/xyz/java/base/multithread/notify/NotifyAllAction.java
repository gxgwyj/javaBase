package com.xyz.java.base.multithread.notify;

import java.util.ArrayList;
import java.util.List;

public class NotifyAllAction {
    public static void main(String[] args) {
        Object lock = new Object();
        List<Thread> threads = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            threads.add(new WaitThread("wait" + i,lock));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
    }
}
