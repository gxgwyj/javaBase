package com.xyz.java.base.multithread.lock;

/**
 * 类: Deadlock <br>
 * 描述: 死锁的例子,取自Oracle官网例子<br>
 * 作者:  gaoxugang<br>
 * 时间: 2019年04月23日 10:40
 */
public class Deadlock {
    /**
     * 静态内部类
     */
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s:%s has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s:%s has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gaston);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
