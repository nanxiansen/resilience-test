package com.test.util.resilience.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author nanzhang
 * @date 2020/3/8
 */
public class MyHystrixCommand extends HystrixCommand {
    protected MyHystrixCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }
}
