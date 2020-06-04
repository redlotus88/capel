package com.c7n.aliyun.terminnology;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 倒计时器
 *
 * 使用场景: 当需要多个线程执行完毕后, 再实行操作时, 可使用CountDownLatch.
 * 实现原理:
 *    内部使用AQS实现的Sync来加锁, 通过sync state来进行计数.
 */
public class CountDownLatchExample {

    // 执行完10次后
    public static CountDownLatch cdLatch = new CountDownLatch(10);

    public static Random NEXT = new Random();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            es.submit(new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(NEXT.nextInt(12));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdLatch.countDown();
                System.out.println("Task " + Thread.currentThread().getName() + " Finished");
            }));
        }

        es.shutdown();

        System.out.println("计数器等待");
        if (cdLatch.await(10, TimeUnit.SECONDS)) {
            System.out.println("倒计时完成");
        } else {
            System.out.println("倒计时超过10秒:" + cdLatch.getCount());
        }
    }
}
