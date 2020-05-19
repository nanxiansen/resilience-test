package com.test.util.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanzhang
 * @date 2020/1/15
 */
public class LogMain {
    private static Logger logger = LogManager.getLogger(LogManager.class);

    private static org.apache.logging.log4j.Logger logger2 = org.apache.logging.log4j.LogManager.getLogger();

    public static void main(String[] args) {

        Map<String, Long> map = new HashMap<>();
        map.put("1", null);
        System.out.println(map.entrySet().stream().filter(entry -> entry.getValue() == 0).findAny());
    }
}
