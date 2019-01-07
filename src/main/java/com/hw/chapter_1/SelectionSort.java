package com.hw.chapter_1;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author hw
 * @Date 2018/12/5 12:13
 * @Version 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        // 基础版 排序
        int[] arr = new int[]{12, 1, 23, 12, 3, 23, 43, 5, 6, 67, 8, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        System.out.println("===================基础版=====================");
        selectionSort(arr);
        System.out.println("===================基础版=====================");
        System.out.println("排序后：" + Arrays.toString(arr));

        System.out.println();
    }

    private static void selectionSort(int[] arr) {

        // 外层总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            System.out.println("第" + i + "步：" + Arrays.toString(arr));

        }
    }

}
