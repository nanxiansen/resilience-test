package com.test.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author nanzhang
 */
public class RedisPool {

    /**
     * 最大重试次数
     */
    private static final int MAX_RETRY = 3;

    private JedisPool pool;

    public RedisPool() {
        this.pool = new JedisPool();
    }

    /**
     * 执行任务
     *
     * @param callable
     */
    public void execute(RedisCallable callable) {
        int count = 0;
        try (Jedis jedis = pool.getResource()) {
            execute(callable, jedis, count);
        }
    }

    private void execute(RedisCallable callable, Jedis jedis, int count) {
        try {
            callable.call(jedis);
        } catch (JedisConnectionException e) {
            if (count < MAX_RETRY) {
                execute(callable, jedis, ++count);
            } else {
                throw e;
            }
        }
    }
}
