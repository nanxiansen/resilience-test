package com.test.util;

import com.test.util.server.RequestParam;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;

/**
 * @author zhangnan
 * @date 2019/08/06 20:45
 */
public class ResilienceTest {

    private static final String DEFAULT_RESULT = "default_result";

    private static final ResilienceTest RESILIENCE_TEST = new ResilienceTest();

    private CircuitBreaker breaker = CircuitBreakerManager.getInstance().getCircuitBreaker("resilience_test");

    public static ResilienceTest getInstance() {
        return RESILIENCE_TEST;
    }

    public String testResilience(RequestParam param) {
        for (int i = 0; i < 1; i++) {
            test(param);
        }
        return "熔断器状态: " + breaker.getState();
    }

    private String test(RequestParam param) {
        CheckedFunction0<String> function = breaker.decorateCheckedSupplier(() -> this.ioOperation(param));
        Try<String> result = Try.of(function);
        return result.getOrElse(DEFAULT_RESULT);
    }

    private String ioOperation(RequestParam param) throws Exception {
        if (param.isError()) {
            throw new Exception();
        }
        return "";
    }
}
