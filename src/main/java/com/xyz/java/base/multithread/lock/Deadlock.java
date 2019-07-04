package com.xyz.java.base.multithread.lock;

/**
 * 类: Deadlock <br>
 * 描述: 死锁的例子,取自Oracle官网例子<br>
 * 构造死锁场景:创建两个子线程,子线程在运行时会分别尝试获取两把锁。
 * 其中一个线程先获取锁1在获取锁2，
 * 另一个线程正好相反。如果没有外界中断，该程序将处于死锁状态永远无法停止。
 * 我们通过使其中一个线程中断，来结束线程间毫无意义的等待。
 * 被中断的线程将抛出异常，而另一个线程将能获取锁后正常结束。
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
