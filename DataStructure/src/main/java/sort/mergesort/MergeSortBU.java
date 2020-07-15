package sort.mergesort;

import sort.SortTestHelper;
import sort.insertsort.StraightInsertSort;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class MergeSortBU {

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
        for (int i = 0; i < arr.length; i += 16)
            StraightInsertSort.sort(arr, i, Math.min(i + 15, arr.length - 1));
        for (int size = 16; size < arr.length; size += size)
            for (int i = 0; i < arr.length - size; i += size + size)
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0)
                    merge(arr, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("sort.mergesort.MergeSortImprove", arr);
        SortTestHelper.testSort("sort.mergesort.MergeSortBU", arr2);
        SortTestHelper.printArray(arr);
    }
}
