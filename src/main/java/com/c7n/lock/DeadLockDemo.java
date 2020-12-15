package com.c7n.lock;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2020/12/15 2:52 PM
 * @since 1.0
 */
public class DeadLockDemo {

    private static final Object r1 = new Object();
    private static final Object r2 = new Object();

    public static void main(String[] args) {
        deadLockDemo();
    }

    /**
     * 竞争资源的死锁示例
     *
     * 可以使用jstack或jconsole查看死锁情况
     *
     */
    public static void deadLockDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("Thread1 - 尝试获取r1锁");
                synchronized (r1) {
                    System.out.println("Thread1 - 获取r1锁");
                    Thread.sleep(2000l);
                    System.out.println("Thread1 - r1执行Thread1逻辑");
                    System.out.println("Thread1 - 尝试获取r2锁");
                    synchronized (r2) {
                        System.out.println("Thread1 - 获取r2锁");
                        Thread.sleep(2000l);
                        System.out.println("Thread1 - r2执行Thread1逻辑");
                    }

                    System.out.println("Thread1 - 释放r2锁");
                }
                System.out.println("Thread1 - 释放r1锁");
            }
        });
        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("Thread2 - 尝试获取r2锁");
                synchronized (r2) {
                    System.out.println("Thread2 - 获取r2锁");
                    Thread.sleep(1000l);
                    System.out.println("Thread2 - r2执行Thread1逻辑");
                    System.out.println("Thread2 - 尝试获取r1锁");
                    synchronized (r1) {
                        System.out.println("Thread2 - 获取r1锁");
                        Thread.sleep(2000l);
                        System.out.println("Thread2 - r1执行Thread1逻辑");
                    }

                    System.out.println("Thread2 - 释放r1锁");
                }
                System.out.println("Thread2 - 释放r2锁");
            }
        });
        executorService.shutdown();
    }
}
