package com.test.util.spring.mvc;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
public class SpringMvcMain {

    private static ServletContext servletContext;

    public static void main(String[] args) {

        WebApplicationContext context = (WebApplicationContext) servletContext.
                getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }
}