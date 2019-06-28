package com.hw.chapter_3;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/5/21 16:22
 * @Version 1.0
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        // 双指针 m i
        int m = 0;
        // [m...i] 为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, m++);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
