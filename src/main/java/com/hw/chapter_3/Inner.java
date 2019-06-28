package com.hw.chapter_3;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/5/14 14:26
 * @Version 1.0
 */
public class Inner {

    public static void main(String[] args) {
        lengthOfLongestSubstring("ababc");

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 0;
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String ss = "";
            for (int j = i; j < len; j++) {
                if (ss.indexOf(chars[j]) == -1) {
                    ss += chars[j];
                    arr.add(ss);
                } else {
                    break;
                }
            }
            if (ss.length() > max) {
                max = ss.length();
            }
        }

        return max;
    }

}
