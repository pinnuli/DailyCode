package sort.quicksort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class QuickSort {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int keyloc = partition(arr, l, r);
            quickSort(arr, l, keyloc - 1);
            quickSort(arr, keyloc + 1, r);
        }
    }

    public static int partition(Comparable[] arr, int l, int r) {
        Comparable key = arr[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(key) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int N = 2000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("sort.quicksort.QuickSort", arr);
//        SortTestHelper.printArray(arr);
        SortTestHelper.testSort("sort.quicksort.QuickSortImprove", arr2);
//        SortTestHelper.printArray(arr2);
    }
}