package com.c7n.spring.springEvent.bean;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by dragon on 2020/1/21.
 */
@Getter
public class SpringEventTransactionalExample extends ApplicationEvent {

    private String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SpringEventTransactionalExample(Object source, String name) {
        super(source);
        this.name = name;
    }
}
