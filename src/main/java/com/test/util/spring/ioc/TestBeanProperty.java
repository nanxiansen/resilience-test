package com.test.util.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
@Component
public class TestBeanProperty {

    public TestBeanProperty() {
        System.out.println("TestBeanProperty");
    }
}
