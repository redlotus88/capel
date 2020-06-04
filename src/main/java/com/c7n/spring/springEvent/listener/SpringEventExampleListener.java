package com.c7n.spring.springEvent.listener;

import com.c7n.spring.springEvent.bean.SpringEventExample;
import com.c7n.spring.springEvent.bean.SpringEventMethodExample;
import com.c7n.spring.springEvent.bean.SpringEventTransactionalExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by dragon on 2020/1/21.
 */
@Slf4j
@Component
@Order(2)
public class SpringEventExampleListener implements ApplicationListener<SpringEventExample> {

    @Override
    public void onApplicationEvent(SpringEventExample event) {
        log.info("Receive Spring Event Example: {}", event.getName());
    }

    @EventListener
    public void springEventMethodExample(SpringEventMethodExample seme) {
        log.info("Receive Spring Event Method Example: {}", seme.getName());
    }

    @EventListener
    public void springEventTransactionExample(SpringEventTransactionalExample sete) throws Exception {
        log.info("Receive Spring Event Transactional Example : {}", sete.getName());
        throw new Exception("error process event");
    }
}

