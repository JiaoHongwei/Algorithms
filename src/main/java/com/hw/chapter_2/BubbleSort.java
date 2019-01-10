package com.hw.chapter_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description 冒泡排序 加强版
 * @Author hw
 * @Date 2019/1/10 16:31
 * @Version 1.0
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }

    }

    @Test
    public void test() {
        int[] arr = new int[]{0, 3, 1, 5, 2, 4, 2, 3};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
