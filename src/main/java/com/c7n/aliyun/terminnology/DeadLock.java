package com.c7n.aliyun.terminnology;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 什么是死锁
 */
public class DeadLock {

    public static void main(String[] args) {
        /**
         * 死锁是指当某一个线程A正在占用临界区资源的使用权,而其必须要另外一临界区资源才能执行完成,
         * 但是存在另一个临界区资源正在被线程B所占有, 且线程B需要线程A持有的资源才能完成, 这个就会导致两个线程都在等待对方
         * 从而产生死锁. 多个线程环形占用资源也是一样的会产生死锁的问题.
         */

        ExecutorService tpe = Executors.newFixedThreadPool(2);

        tpe.execute(new DeadThread1());
        tpe.execute(new DeadThread2());
        // 死锁了
        tpe.shutdown();
    }

    public static Object resource1 = new Object();
    public static Object resource2 = new Object();

    static class DeadThread1 implements Runnable {

        @Override
        public void run() {
            synchronized (resource1) {
                System.out.println("Dead Thread1 占有了 resource1");
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Dead Thread1 占有了 resource2");

                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Dead Thread1 完成了任务");
        }
    }

    static class DeadThread2 implements Runnable {

        @Override
        public void run() {
            synchronized (resource2) {
                System.out.println("Dead Thread2 占有了 resource2");
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Dead Thread2 占有了 resource1");

                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Dead Thread2 完成了任务");
        }
    }
}
