package com.test.util.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}
