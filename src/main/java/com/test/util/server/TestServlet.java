package com.test.util.server;

import com.test.util.ResilienceTest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author zhangnan
 * @date 2019/08/13 16:59
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        RequestParam param = buildParam(request);

        try {
            response.getWriter().println(ResilienceTest.getInstance().testResilience(param));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RequestParam buildParam(HttpServletRequest request) {
        RequestParam param = new RequestParam();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if (entry.getKey() == null || entry.getValue().length == 0) {
                continue;
            }
            if ("error".equals(entry.getKey())) {
                boolean error = Optional.ofNullable(entry.getValue()[0])
                        .filter("true"::equals).isPresent();
                param.setError(error);
                break;
            }
        }
        return param;
    }

}
