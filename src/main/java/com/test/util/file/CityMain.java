package com.test.util.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangnan
 * @date 2019/10/23 16:02
 */
public class CityMain {

    private static final String ROOT = "/Users/zhangnan/test_file/";

    public static void main(String[] args) {
        // 线上
        String readOnline = ROOT + "线上城市.json" ;
        String writeOnline = ROOT + "online_city.csv";
        handleCity(readOnline, writeOnline);

        //
        String readTest = ROOT + "测试城市.json" ;
        String writeTest = ROOT + "test_city.csv";
        handleCity(readTest, writeTest);

    }

    private static void handleCity(String readPath, String writePath) {
        JSONObject content = FileUtil.readJsonFromFile(readPath);
        List<String> lines = handleJson(content);
        FileUtil.writeToFile(lines, writePath);
    }

    private static List<String> handleJson(JSONObject content) {
        if (content == null || content.isEmpty()) {
            return Collections.emptyList();
        }
        JSONArray data = content.getJSONArray("data");
        List<String> lines = new ArrayList<>(data.size());
//        lines.add("id,name");
        data.stream().filter(o -> o instanceof JSONObject)
                .map(o -> (JSONObject) o)
                .forEach(json -> {
                    String line = json.getString("id") + "," + json.getString("name");
                    lines.add(line);
                });
        return lines.stream().distinct().collect(Collectors.toList());
    }
}
