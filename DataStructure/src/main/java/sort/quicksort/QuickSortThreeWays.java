package sort.quicksort;

import sort.SortTestHelper;
import sort.insertsort.StraightInsertSort;

/**
 * 三路快速排序
 * 对于有大量重复值的数组，快速排序会退化为n的平方，可以使用双路快速排序解决。
 *
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class QuickSortThreeWays {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(Comparable[] arr, int l, int r) {
        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            StraightInsertSort.sort(arr, l, r);
            return;
        }
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];
        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }

        swap(arr, l, lt);
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
    }


    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[20000];
        arr[0] = 1;
        for (int i = 1; i < 20000; i++) {
            arr[i] = 0;
        }
        SortTestHelper.testSort("sort.quicksort.QuickSortTwoWays", arr);
        SortTestHelper.printArray(arr);
    }
}