package sort.mergesort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class MergeSort {

    public static void merge(Comparable[] arr, int low, int mid, int high) {
        Comparable[] arrBak = new Comparable[arr.length];
        for (int i = low; i <= high; i++) {
            arrBak[i] = arr[i];
        }
        int l = low, r = mid + 1, i;
        for (i = low; i <= high && l <= mid && r <= high; i++) {
            if (arrBak[l].compareTo(arrBak[r]) < 0) {
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
    }

    public static void sort(Comparable[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high + low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.mergesort.MergeSort", arr);
        SortTestHelper.printArray(arr);
    }
}
