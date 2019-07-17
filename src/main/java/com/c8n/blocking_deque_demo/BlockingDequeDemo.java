package com.c8n.blocking_deque_demo;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by dragon on 2019/5/31.
 */
public class BlockingDequeDemo {

    public static BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(2);

    public static void main(String[] args) {
        int maxThreadNum = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors.newFixedThreadPool(maxThreadNum);
        executors.setKeepAliveTime(30, TimeUnit.SECONDS);

        IntStream.range(1, 10).parallel().forEach((i) ->
                executors.submit(() -> saveQueue(i))
        );

        System.out.println("分配完毕");

        while (queue.peekFirst() != null) {
            try {
                Thread.currentThread().sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("队列还有数据");
        }

        executors.shutdownNow();

        if (executors.isTerminated()) {
            System.out.println("线程执行完毕");
        }
    }

    public static void saveQueue(Integer i) {
        System.out.println("准备插入queue | " + i);
        try {
            queue.putLast(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("插入成功 | " + i);
        try {
            Thread.currentThread().sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("弹出queue | " + queue.removeFirst());
    }
}
