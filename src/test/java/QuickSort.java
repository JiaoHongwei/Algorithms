import javax.swing.*;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/28 14:12
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 1, 2, 4, 1, 5, 6, 2, 5};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 采用三数中值分割法
        int mid = left + (right - left) / 2;
        // 保证左端最小
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        // 保证中间较小
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        // 保证中间最小，左右最大
        if (arr[mid] > arr[left]) {
            swap(arr, left, mid);
        }
        int pivot = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (pivot <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于 arr[right] ，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是arr[right] 需要填坑了
            while (pivot >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = pivot;
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


}
