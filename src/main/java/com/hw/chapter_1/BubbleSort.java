package com.hw.chapter_1;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author hw
 * @Date 2018/12/4 18:21
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 基础版 排序
        int[] arr = new int[]{12, 1, 23, 12, 3, 23, 43, 5, 6, 67, 8, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        System.out.println("===================基础版=====================");
        bubbleSort(arr);
        System.out.println("===================基础版=====================");
        System.out.println("排序后：" + Arrays.toString(arr));

        System.out.println();

        // 高级版 排序
        arr = new int[]{12, 1, 23, 12, 3, 23, 43, 5, 6, 67, 8, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        System.out.println("===================高级版=====================");
        bubbleSortPlus(arr);
        System.out.println("===================高级版=====================");
        System.out.println("排序后：" + Arrays.toString(arr));

    }

    /**
     * 基础班
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            System.out.println("第" + i + "步：" + Arrays.toString(arr));
        }
    }


    /**
     * 增强版
     */
    private static void bubbleSortPlus(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            /**
             * 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序已经有序，排序已经完成
             */
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            System.out.println("第" + i + "步：" + Arrays.toString(arr));
            if (flag) {
                break;
            }
        }
    }
}
