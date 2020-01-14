package com.c8n.aliyun.terminnology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 */
public class DistributedLock {

    public static int cs = new Integer(0);

    @Autowired
    public static StringRedisTemplate stringRedisTemplate;

    static class Transaction implements Runnable {
        @Override
        public void run() {
            if (stringRedisTemplate.opsForValue().setIfAbsent("lock.cs", "1")) {
                // Do a transaction
                DistributedLock.cs += 1;
            }
        }
    }
}
