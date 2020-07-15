package sort.selectsort;

import sort.SortTestHelper;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class SelectSort {

    public static void sort(Comparable[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length -1; i++){
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if( arr[j].compareTo( arr[minIndex] ) < 0 )
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.selectsort.SelectSort", arr);
        SortTestHelper.printArray(arr);
    }
}
