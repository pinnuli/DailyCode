package sort.insertsort;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-22
 */

public class BinaryInsertSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int i, j, temp, low, hight, middle;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]){
                temp = arr[i];
                low = 0;
                hight = i - 1;
                while (low <= hight) {
                    middle = (low + hight) / 2;
                    if (temp < arr[middle]) {
                        hight = middle - 1;
                    } else {
                        low = middle + 1;
                    }
                }
                for (j = i - 1; j >= hight + 1; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[hight + 1] = temp;
            }
            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 6, 7, -12, 2, 17};
        sort(arr);
    }
}
