package sort;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class HeapSort {

    public static void heapAdjust(int[] arr, int s, int m) {
        int temp = arr[s];
        for (int j = 2 * s; j <= m; j = j * 2) {
            if (j < m && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp >= arr[j]){
                break;
            }
            arr[s] = arr[j];
            s = j;
        }
        arr[s] = temp;
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapAdjust(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 6, 7, -12, 2, 17, -10, -4, 8, 0, 17, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
