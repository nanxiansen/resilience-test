package com.test.util.common;

/**
 * @author zhangnan
 * @date 2019/10/31 16:59
 */
public class StringUtils {

    public static boolean isNotEmpty( String content) {
        return content != null && !content.isEmpty();
    }

    public static boolean isEmpty(String content) {
        return !isNotEmpty(content);
    }
}
