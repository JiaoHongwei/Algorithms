import java.util.Arrays;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/28 14:12
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 1, 2, 4, 1, 5, 6, 2, 5};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
