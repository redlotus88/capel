package com.c8n.aliyun.terminnology;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  分布式锁的应用
 */
@Slf4j
@NoArgsConstructor
@Component
public class DistributedLock {

    public static int cs = new Integer(0);

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    public void runExampleBasedOnRedis() throws InterruptedException {
        TransactionBasedOnRedis t1 = new TransactionBasedOnRedis("t1", stringRedisTemplate);
        TransactionBasedOnRedis t2 = new TransactionBasedOnRedis("t2", stringRedisTemplate);
        TransactionBasedOnRedis t3 = new TransactionBasedOnRedis("t3", stringRedisTemplate);

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(t1);
        es.submit(t2);
        es.submit(t3);

        es.shutdown();

        Thread.sleep(5000L);
    }

    /**
     * 基于Redis的分布式锁
     */
    static class TransactionBasedOnRedis implements Runnable {

        private String name;

        @Autowired
        public StringRedisTemplate stringRedisTemplate;

        public TransactionBasedOnRedis(String name, StringRedisTemplate stringRedisTemplate) {
            this.name = name;
            this.stringRedisTemplate = stringRedisTemplate;
        }

        @Override
        public void run() {
            try {
                log.info(name + " Start task");
                if (stringRedisTemplate.opsForValue().setIfAbsent("lock.cs", "1")) {
                    // Do a transaction
                    DistributedLock.cs += 1;
                    log.info(name + " Change the cs value");
                } else {
                    log.info(name + " Do not change the cs value");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
