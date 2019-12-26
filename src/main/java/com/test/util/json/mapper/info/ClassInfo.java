package com.test.util.json.mapper.info;

import com.test.util.json.mapper.deserializer.BaseDeserializer;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author zhangnan
 * @date 2019/10/31 17:09
 */
public class ClassInfo<T> {

    private String className;

    private Class<T> type;

    private Map<String, ClassInfo> propInfoMap;

    private BaseDeserializer deserializer;

    private Method setter;

    public T newInstanse() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
