package com.test.util.lru;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2019/12/10 14:22
 */
public class LruMain {

    public static void main(String[] args) {

        RemovalListener<Integer, String> removalListener = (notification) -> {
            System.out.println(String.format("remove, cause: %s, key: %d, value: %s", notification.getCause(),
                    notification.getKey(), notification.getValue()));
        };

        LoadingCache<Integer, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .concurrencyLevel()
                .maximumWeight()
                .refreshAfterWrite()
                .expireAfterAccess()
                .initialCapacity()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(removalListener)
                .build(
                        new CacheLoader<Integer, String>() {
                            @Override
                            public String load(Integer key) throws Exception {
                                System.out.println(String.format("load, key: %d", key));
                                return String.valueOf(key);
                            }
                        });

        ConcurrentLinkedHashMap map;
        map.get();
        map.put()
    }
}
