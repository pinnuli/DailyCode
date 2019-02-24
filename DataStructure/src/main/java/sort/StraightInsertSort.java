package sort;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-22
 */

public class StraightInsertSort {

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int i, j;
        for (i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]) {
                int temp = arr[i];
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j+1] = temp;
            }
            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 6, 7, -12, 2, 17};
        sort(arr);
    }
}
