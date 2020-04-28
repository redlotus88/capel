package com.c8n.spring.springEvent.listener;

import com.c8n.spring.springEvent.bean.SpringEventExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by dragon on 2020/3/9.
 */
@Slf4j
@Component
@Order(1)
public class SpringEventExampleSecondListener implements ApplicationListener<SpringEventExample> {

    @Override
    public void onApplicationEvent(SpringEventExample event) {
        log.info("Second Listener receive Spring Event Example: {}", event.getName());
    }
}
