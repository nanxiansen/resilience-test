package com.test.util.resilience.resilience4j;

import com.test.util.resilience.server.RequestParam;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;

/**
 * @author zhangnan
 * @date 2019/08/06 20:45
 */
public class Resilience4jService {

    private static final String DEFAULT_RESULT = "default_result";

    private static final Resilience4jService RESILIENCE_TEST = new Resilience4jService();

    private CircuitBreaker breaker = CircuitBreakerManager.getInstance().getCircuitBreaker("resilience_test");

    public static Resilience4jService getInstance() {
        return RESILIENCE_TEST;
    }

    public String serve(RequestParam param) {
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
