package com.test.util.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.eclipse.jetty.util.StringUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangnan
 * @date 2019/10/23 16:03
 */
public class FileUtil {

    public static String readFile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return null;
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static JSONObject readJsonFromFile(String path) {
        String contentStr = readFile(path);
        if (StringUtil.isEmpty(contentStr)) {
            return new JSONObject(0);
        }
        try {
            return JSONObject.parseObject(contentStr);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject(0);
        }
    }

    public static JSONArray readJsonArrayFromFile(String path) {
        String contentStr = readFile(path);
        if (StringUtil.isEmpty(contentStr)) {
            return new JSONArray(0);
        }
        try {
            return JSONArray.parseArray(contentStr);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray(0);
        }
    }

    public static boolean writeToFile(List<String> lines, String path) {
        File file = new File(path);
        if (!file.isFile()) {
            try {
                if (!file.createNewFile()) {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        StringBuilder content = new StringBuilder();
        lines.stream().filter(Objects::nonNull)
                .map(s -> s + "\n")
                .forEach(content::append);

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(content.toString());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
