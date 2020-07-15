package sort.insertsort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-22
 */

public class StraightInsertSort {

    public static void sort(Comparable[] arr) {
        int i, j;
        for (i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            for (j = i - 1; j >= 0 && temp.compareTo(arr[j]) < 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){
        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("sort.selectsort.SelectSort", arr1);
        SortTestHelper.testSort("sort.insertsort.StraightInsertSort", arr2);
        SortTestHelper.printArray(arr1);
        SortTestHelper.printArray(arr2);
    }
}
