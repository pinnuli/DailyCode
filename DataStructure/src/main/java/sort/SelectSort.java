package sort;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class SelectSort {

    public static void sort(int[] arr) {
        if (arr.length <= 1 || arr == null) {
            return;
        }
        int temp, min, flag;
        for (int i = 0; i < arr.length -1; i++){
            min = arr[i];
            flag = i;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    flag = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[flag];
            arr[flag] = temp;
            System.out.println("第" + (i+1) + "次：" + Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int[] arr = null;
        sort(arr);
    }
}
