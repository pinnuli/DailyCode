package sort.mergesort;

import sort.SortTestHelper;
import sort.insertsort.StraightInsertSort;

import java.util.Arrays;

/**
 * 归并排序优化
 * 1. 对于arr[mid] <= arr[mid+1]的情况,不进行merge，对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
 * 2. 对于小规模数组, 使用插入排序
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class MergeSortImprove {

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
        // 优化2: 对于小规模数组, 使用插入排序
        if (high - low <= 15) {
            StraightInsertSort.sort(arr, low, high);
            return;
        }
        int mid = (high + low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge,
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, low, mid, high);
        }
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("sort.mergesort.MergeSort", arr);
        SortTestHelper.testSort("sort.mergesort.MergeSortImprove", arr2);
        SortTestHelper.printArray(arr);
    }
}
