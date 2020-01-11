package com.test.util.spring;

import com.test.util.spring.ioc.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
@SpringBootApplication
public class SpringMain {

    @Autowired
    public static TestBean testBean;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringMain.class);
    }
}
