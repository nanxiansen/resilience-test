package com.test.util.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author nanzhang
 * @date 2020/1/31
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        for (int i = 0; i < 10; i++) {
            sleepMillSeconds(100);
            service.execute(() -> System.out.println("current thread: " + Thread.currentThread().getName()));
        }
    }

    private static void sleepMillSeconds(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
