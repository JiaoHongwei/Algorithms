package com.hw.chapter_1;

/**
 * @Description 二分查找
 * @Author hw
 * @Date 2019/3/15 12:06
 * @Version 1.0
 */
public class BinarySearch {

    public static boolean binarySearch(int[] arr, int start, int end, int value) {

//        int mid = (start + end) / 2;
        int mid = start + (end - start) / 2;
        if (start >= end) {
            return false;
        }
        if (arr[mid] == value) {
            return true;
        }
        if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, end, value);
        } else if (arr[mid] > value) {
            return binarySearch(arr, start, mid - 1, value);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean flag = binarySearch(arr, 0, arr.length, 5);
        System.out.println(flag);
    }
}
