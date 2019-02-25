package com.hw.chapter_1;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/2/25 18:52
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static boolean find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
