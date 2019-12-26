package com.test.util.json.mapper;

import com.test.util.common.StringUtils;

/**
 * @author zhangnan
 * @date 2019/10/31 16:56
 */
public class ObjectMapper {

    public static <T> T fromJson(String content, Class<T> type) {
        // 校验
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        if (type == null) {
            return null;
        }

        // 反射加载类型信息

        return null;
    }
}
