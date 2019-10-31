package com.test.util.resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangnan
 * @date 2019/08/13 12:13
 */
public class CircuitBreakerManager {

    private static final float FAILURE_RATE = 50;
    private static final Duration WAIT_DURATION = Duration.ofMillis(2000);
    private static final int HALF_OPEN_BUFFER_SIZE = 3;
    private static final int CLOSED_BUFFER_SIZE = 3;

    private static final CircuitBreakerManager CIRCUIT_BREAKER_MANAGER = new CircuitBreakerManager();

    private ConcurrentHashMap<String, CircuitBreaker> circuitBreakerMap = new ConcurrentHashMap<>();
    private CircuitBreakerConfig config = CircuitBreakerConfig.custom()
            .failureRateThreshold(FAILURE_RATE)
            .ringBufferSizeInHalfOpenState(HALF_OPEN_BUFFER_SIZE)
            .ringBufferSizeInClosedState(CLOSED_BUFFER_SIZE)
            .enableAutomaticTransitionFromOpenToHalfOpen()
            .waitDurationInOpenState(WAIT_DURATION)
            .build();
    private CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);

    public static CircuitBreakerManager getInstance() {
        return CIRCUIT_BREAKER_MANAGER;
    }

    public CircuitBreaker getCircuitBreaker(String name) {
        if (circuitBreakerMap.containsKey(name)) {
            return circuitBreakerMap.get(name);
        }
        CircuitBreaker circuitBreaker = registry.circuitBreaker(name);
        return Optional.ofNullable(circuitBreakerMap.putIfAbsent(name, circuitBreaker)).orElse(circuitBreaker);
    }
}
