package sort;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] arrBak = new int[arr.length];
        for (int i = low; i <= high; i++) {
            arrBak[i] = arr[i];
        }
        int l = low, r = mid + 1, i;
        for (i = low; i <= high && l <= mid && r <= high; i++) {
            if (arrBak[l] < arrBak[r]) {
                arr[i] = arrBak[l++];
            } else {
                arr[i] = arrBak[r++];
            }
        }
        while (l <= mid) {
            arr[i++] = arrBak[l++];
        }
        while (r <= high) {
            arr[i++] = arrBak[r++];
        }
        System.out.println(low + ":" + high + ":" + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (high - low) / 2 + low;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 6, 7, -12, 2, 17, -10, -4, 8, 0, 17, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
