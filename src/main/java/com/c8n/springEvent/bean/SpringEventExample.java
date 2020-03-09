package com.c8n.springEvent.bean;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Created by dragon on 2020/1/21.
 */
@Getter
public class SpringEventExample extends ApplicationEvent {

    private String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SpringEventExample(Object source, String name) {
        super(source);
        this.name = name;
    }
}
