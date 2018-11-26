package sort;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class BubbleSort {

    public static void sort(int[] arr) {
        int temp;
        boolean change = true;
        for (int i = 0; i < arr.length - 1 && change; i++) {
            change = false;
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1]) {
                    change = true;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (i+1) + "次：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 6, 7, -12, 2, 17, -10, -4, 8, 0, 17, 5};
        sort(arr);
    }
}
