package com.c8n.springEvent;

import com.c8n.ApplicationTest;
import com.c8n.springEvent.bean.SpringEventExample;
import com.c8n.springEvent.bean.SpringEventMethodExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dragon on 2020/1/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class SpringEventDemoTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringEventService springEventService;

    @Test
    public void exampleTest() {
        SpringEventExample see = new SpringEventExample(this, "test1");
        applicationContext.publishEvent(see);
    }

    @Test
    public void exampleMethodTest() {
        SpringEventMethodExample seme = new SpringEventMethodExample(this, "test2");
        applicationContext.publishEvent(seme);
    }

    @Test
    public void exampleTransactionalText() {
        springEventService.doAFailedTransaction();
    }

    @Test
    public void testEventExecuteOrder() {
        // Use @Order to change execution order.
        SpringEventExample see = new SpringEventExample(this, "test1");
        applicationContext.publishEvent(see);
    }
}
