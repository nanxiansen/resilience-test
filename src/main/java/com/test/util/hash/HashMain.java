package com.test.util.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanzhang
 * @date 2020/2/29
 */
public class HashMain {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            map.put(i, String.valueOf(i));
        }

    }
}
