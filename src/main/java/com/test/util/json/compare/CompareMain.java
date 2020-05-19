package com.test.util.json.compare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.util.file.FileUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompareMain {

    private static String pathNew = "/Users/nanzhang/github/resilience-test/src/main/resources/new.json";
    private static String pathOld = "/Users/nanzhang/github/resilience-test/src/main/resources/old.json";
    private static String result = "/Users/nanzhang/github/resilience-test/src/main/resources/result.json";

    private static JSONArray jsonNew = JsonLoader.loadAdDetail(pathNew);
    private static JSONArray jsonOld = JsonLoader.loadAdDetail(pathOld);

    public static void main(String[] args) {

        List<JSONObject> list = handleAdDetail();
        System.out.println("new.size: " + jsonNew.size());
        System.out.println("old.size: " + jsonOld.size());

        JSONArray array = JSON.parseArray(JSON.toJSONString(list));
        FileUtil.writeToFile(Arrays.asList(array.toJSONString()), result);

    }

    private static List<JSONObject> handleAdDetail() {
        return jsonOld.stream()
                .map(o -> (JSONObject) o)
                .filter(o -> !contains(jsonNew, o))
                .collect(Collectors.toList());
    }

    private static List<JSONObject>  handlePidRule() {
        return jsonOld.stream()
                .map(o -> (JSONObject) o)
                .peek(o -> {
                    JSONObject detail = o.getJSONObject("detail");
                    detail.remove("id");
                    o.put("detail", detail);
                })
                .filter(o -> !pidRuleContains(jsonNew, o))
                .collect(Collectors.toList());
    }

    private static boolean contains(JSONArray json, JSONObject obj) {
        return json.stream().map(o -> (JSONObject) o).anyMatch(o -> jsonEquals(o, obj));
    }

    private static boolean pidRuleContains(JSONArray json, JSONObject obj) {
        return json.stream().map(o -> (JSONObject) o)
                .anyMatch(o -> jsonEquals(o.getJSONObject("detail").getJSONObject("pIDAdjustmentPrice"),
                        obj.getJSONObject("detail").getJSONObject("pIDAdjustmentPrice")));
    }

    private static boolean jsonEquals(JSONObject json1, JSONObject json2) {
        if (json1.size() != json2.size()) {
            return false;
        }

        return json1.entrySet().stream()
                .allMatch(entry -> Objects.equals(entry.getValue().toString(), json2.getString(entry.getKey())));
    }
}
