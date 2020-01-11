package com.test.util.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
@Component
public class TestBean {

    @Autowired
    private TestBeanProperty testBeanProperty;

    public TestBean() {
        System.out.println("TestBean");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct");
    }

    public TestBean getTestBean() {
        return new TestBean();
    }
}
