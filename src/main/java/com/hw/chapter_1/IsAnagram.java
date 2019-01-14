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
        return Arrays.equals(a,b);
    }

    @Test
    public void test() {
        String a = "abcd";
        String b = "dcba";
        System.out.println(isAnagram(a, b));
    }
}
