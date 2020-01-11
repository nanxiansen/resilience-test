package com.test.util.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
public class MyEventManager implements ApplicationContextAware {
    private ApplicationContext appCtx = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }

    public void publish(ApplicationEvent event) {
        if (event != null) {
            appCtx.publishEvent(event);
        }
    }
}
