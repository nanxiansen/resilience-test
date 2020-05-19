package com.test.util.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nanzhang
 * @date 2020/3/11
 */
public class TestMain {

    private static String s1 = "189^5^-1,999^18^314159,4^3^390,188^36^2290,188^50^2276,2^5^-1,188^28^2254,188^23^2286,2^7^-1,2^9^-1,188^34^2250,188^29^2256,188^27^2264,188^32^2282,188^30^2278,188^24^2262,188^22^2258,188^25^2260,188^38^2292,188^33^2284,2^4^-1,188^20^2293,2^8^-1,188^26^2266,188^31^2280,188^37^2288,188^21^2274,188^35^2252,2^4^-1";
    private static String s2 = "189^5^1161,999^18^314159,4^3^392,188^20^2155,2^5^369,188^26^2164,188^21^2157,2^8^1199,188^22^2169,188^25^2159,2^4^265,2^7^560,188^27^2167,2^9^1223,4^3^392,188^20^2155,2^5^369,188^26^2164,188^21^2157,2^8^1199,188^22^2169,188^25^2159,2^4^265,2^7^560,188^27^2167,2^9^1223,2^8^1199,2^7^560,2^4^265";

    public static void main(String[] args) {

        String[] s1Group = s1.split(",");
        String[] s2Group = s2.split(",");

        Set<String> set1 = new HashSet<>(Arrays.asList(s1Group));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2Group));

        boolean equal = set1.size() == set2.size() && set1.containsAll(set2);
        System.out.println(equal);
    }
}
