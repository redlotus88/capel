package com.c8n.aliyun.terminnology;

import com.c8n.ApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dragon on 2020/1/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class DistributedLockTests {

    @Autowired
    private DistributedLock distributedLock;

    @Test
    public void test() throws InterruptedException {
        distributedLock.runExampleBasedOnRedis();
    }
}
