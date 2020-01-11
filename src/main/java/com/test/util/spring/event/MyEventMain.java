package com.test.util.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author nanzhang
 * @date 2020/1/10
 */
public class MyEventMain {

    public static void main(String[] args) {
        ApplicationContext appCtx = new FileSystemXmlApplicationContext("src/main/resources/spring/myConfig.xml");
        MyEvent myEvent = (MyEvent) appCtx.getBean("myEvent");
        MyEventManager myEventManager = (MyEventManager) appCtx.getBean("myEventManager");
        //发布事件
        myEventManager.publish(myEvent);
    }
}
