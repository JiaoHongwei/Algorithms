package com.hw.chapter_1;

import java.rmi.dgc.Lease;
import java.util.Arrays;

/**
 * @Description 判断两个字符串是否相同（字符个数出现次数相同） ASCII
 * // aaaabbc
 * // abcbaaa
 * @Author hw
 * @Date 2019/3/12 16:34
 * @Version 1.0
 */
public class SameString {

    public static boolean sameString2(String a, String b) {
        byte[] aBytes = a.getBytes();
        byte[] bBytes = b.getBytes();
        Arrays.sort(aBytes);
        Arrays.sort(bBytes);
        return Arrays.equals(aBytes, bBytes);
    }

    public static boolean sameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        byte[] bytes_a = a.getBytes();
        byte[] bytes_b = b.getBytes();
        int[] arr = new int[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < bytes_a.length; i++) {
            arr[bytes_a[i] - '0']++;
            arr[bytes_b[i] - '0']--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = sameString("aabcbxaxgxgggggcc", "aaxxgggcgggaxbbcc");
        System.out.println(b);
        System.out.println(Arrays.toString("abcd".getBytes()));
        System.out.println(Arrays.toString("ABCD".getBytes()));

    }
}
