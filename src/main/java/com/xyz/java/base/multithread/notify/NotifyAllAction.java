package com.xyz.java.base.multithread.notify;

import java.util.ArrayList;
import java.util.List;

public class NotifyAllAction {
    public static void main(String[] args) {
        Object lock = new Object();

        List<Thread> threads = new ArrayList<>(3);
        for (int i = 0; i < 300; i++) {
            threads.add(new WaitThread("wait" + i, lock));
        }

        List<Thread> noWaitThreadList = new ArrayList<>(3);
        for (int i = 0; i < 100; i++) {
            noWaitThreadList.add(new NoWaitThread("no-waite" + i, lock));
        }


        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.setOtherList(noWaitThreadList);

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }
}
