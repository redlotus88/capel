package com.c7n.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 资源有序分配法
 *
 * 对资源的获取按顺序请求，可以保证死锁不会出现。
 *
 * @author jialong.wang
 * @Date on 2020/12/15 2:18 PM
 * @since 1.0
 */
public class ResourceOrderlyAssignment {

    private static final Resource r1 = Resource.newResource();
    private static final Resource r2 = Resource.newResource();

    public static void main(String[] args) {
        manualKeepOrder();
    }

    public static void manualKeepOrder() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            synchronized (r1) {
                try {
                    Thread.sleep(2000l);
                    synchronized (r2) {
                        Thread.sleep(2000l);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            // 手动保证资源获取的顺序 r1 -> r2
            synchronized (r1) {
                try {
                    Thread.sleep(1000l);
                    synchronized (r2) {
                        Thread.sleep(2000l);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
    }

}
