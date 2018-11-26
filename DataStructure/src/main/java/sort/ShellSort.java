package sort;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-22
 */

public class ShellSort {
    public static void sort(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        int i, j, temp, dk = arr.length / 4 + 1;
        while (dk > 0) {
            for (i = dk; i < arr.length; i++) {
                temp = arr[i];
                for (j = i - dk; j >= 0 && temp < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = temp;
            }
            dk /= 2;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 6, 7, -12, 2, 17, -10, -4, 8, 0, 17, 5};
        sort(arr);
    }
}
