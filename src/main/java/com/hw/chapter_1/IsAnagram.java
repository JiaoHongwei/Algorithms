package com.hw.chapter_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description 判断两个字符串是不是异位词
 * @Author hw
 * @Date 2019/1/10 18:56
 * @Version 1.0
 */
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String a = "abcdhuhuhu";
        String b = "dcbahuhuhu";
        System.out.println(isAnagram(a, b));
        System.out.println(isAnagram2(a, b));
    }
}
