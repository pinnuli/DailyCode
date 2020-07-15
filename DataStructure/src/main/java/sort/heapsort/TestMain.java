package sort.heapsort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * @author linxiaoyi
 * @date 2020/5/24
 */
public class TestMain {
    /// 比较 Merge Sort, 三种 Quick Sort 和本节介绍的两种 Heap Sort 的性能效率
    // 注意, 这几种排序算法都是 O(nlogn) 级别的排序算法
    public static void main(String[] args) {

        int N = 100000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.mergesort.MergeSort", arr1);
        SortTestHelper.testSort("sort.quicksort.QuickSort", arr2);
        SortTestHelper.testSort("sort.quicksort.QuickSortTwoWays", arr3);
        SortTestHelper.testSort("sort.quicksort.QuickSortThreeWays", arr4);
        SortTestHelper.testSort("sort.heapsort.HeapSort1", arr5);
        SortTestHelper.testSort("sort.heapsort.HeapSort2", arr6);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.mergesort.MergeSort", arr1);
        SortTestHelper.testSort("sort.quicksort.QuickSort", arr2);
        SortTestHelper.testSort("sort.quicksort.QuickSortTwoWays", arr3);
        SortTestHelper.testSort("sort.quicksort.QuickSortThreeWays", arr4);
        SortTestHelper.testSort("sort.heapsort.HeapSort1", arr5);
        SortTestHelper.testSort("sort.heapsort.HeapSort2", arr6);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for repeatedly array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.mergesort.MergeSort", arr1);
//         这种情况下, 普通的QuickSort退化为O(n^2)的算法, 不做测试
//        SortTestHelper.testSort("sort.quicksort.QuickSort", arr2);
        SortTestHelper.testSort("sort.quicksort.QuickSortTwoWays", arr3);
        SortTestHelper.testSort("sort.quicksort.QuickSortThreeWays", arr4);
        SortTestHelper.testSort("sort.heapsort.HeapSort1", arr5);
        SortTestHelper.testSort("sort.heapsort.HeapSort2", arr6);

    }
}
