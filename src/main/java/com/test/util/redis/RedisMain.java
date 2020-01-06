package com.test.util.redis;

/**
 * @author nanzhang
 */
public class RedisMain {

    public static void main(String[] args) {
        RedisPool pool = new RedisPool();
        pool.execute((jedis) -> {
            System.out.println(jedis.get("key"));
        });
    }
}
