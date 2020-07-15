package sort.bubblesort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class BubbleSort {

    public static void sort(Comparable[] arr) {
        boolean change = true;
        for (int i = 0; i < arr.length - 1 && change; i++) {
            change = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    change = true;
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortImprove(Comparable[] arr) {
        int n = arr.length - 1;
        int newn; // 使用newn进行优化
        do {
            newn = 0;
            for (int i = 0; i < n; i++)
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i + 1;
                }
            n = newn;
        } while (newn > 0);
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.bubblesort.BubbleSort", arr);
        SortTestHelper.printArray(arr);
    }
}
