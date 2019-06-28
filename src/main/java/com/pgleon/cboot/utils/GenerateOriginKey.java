package com.pgleon.cboot.utils;

import java.util.Random;

/**
 * @Auther: leon
 * @Date: 2019-06-25 19:52
 * @Description:
 */
public class GenerateOriginKey {

    public static void main(String[] args) {
        String version = "web-admin-v1.0";
        String key = genRandomOriginKey(version);
        System.out.println(String.format(".put(\"%s\", \"%s\")", version, key));
    }


    public static String genRandomOriginKey(String version) {
        Random random = new Random();
        int ran = random
                .nextInt(10000);
        char[] chars = (version + ran).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ran = random.nextInt(chars.length);
            chars[i] = chars[ran];
        }
        return new String(chars);
    }
}
