package com.test.util.redis;

import redis.clients.jedis.Jedis;

/**
 * 回调接口，用于传递给RedisPool
 *
 * @author nanzhang
 */
public interface RedisCallable {

    /**
     * 回调方法，执行需要执行的任务
     *
     * @param jedis jedis
     */
    void call(Jedis jedis);
}
