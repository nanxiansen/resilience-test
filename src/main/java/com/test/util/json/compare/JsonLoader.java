package com.test.util.json.compare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.test.util.file.FileUtil;

public class JsonLoader {

    public static JSONArray loadAdDetail(String path) {
        return load(path, "details");
    }

    public static JSONArray loadPidRule(String path) {
        return load(path, "info");
    }

    private static JSONArray load(String path, String key) {
        String content = FileUtil.readFile(path);
        return JSON.parseObject(content).getJSONObject("data").getJSONArray(key);
    }
}
