package com.c7n.aliyun.terminnology;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 什么是线程安全?
 */
public class ThreadSafe {

    public static void main(String[] args) {
        /**
         * 线程安全是指在拥有共享数据的多条线程并行执行的程序中,
         * 线程安全的代码会通过同步机制保证各个线程都可以正常且正确的执行,不会出现数据污染的情况.
         *
         * 线程安全发生的条件:
         *  1. 多线程环境下,即存在包括自己在内存有多个线程
         *  2. 多线程环境下存在共享资源, 且多线程操作该共享资源(临界区资源)
         *  3. 多个线程必须对该共享资源有非原子性操作
         *
         * 线程安全的策略:
         *  1. 原子性操作 Atomic原子类
         *  2. Synchronized同步操作
         *  3. volatile锁 保证线程之间的可见性
         *  4. Lock锁 ReentrantLock
         */
        ExecutorService es = Executors.newFixedThreadPool(4);

        es.execute(new ThreadExample());
        es.execute(new ThreadExample());
        es.execute(new ThreadExample());
        es.execute(new ThreadExample());
        es.shutdown();
        System.out.println("线程执行完毕");
    }

    // 全局共享变量
    public static Integer cash = 1000;

    // 使用AtomicCash来保证原子性
    public static AtomicInteger atomicCash = new AtomicInteger(1000);

    public static volatile Integer voCash = 1000;

    static class ThreadExample implements Runnable {

        @Override
        public void run() {
            synchronized (cash) {
                cash = cash + 100;
                int result = ThreadSafe.cash;
                System.out.println(Thread.currentThread().getName() + ", cash = " + result);
            }

            System.out.println(Thread.currentThread().getName() + ", atomic cash = " + ThreadSafe.atomicCash.addAndGet(100));
        }
    }

}
