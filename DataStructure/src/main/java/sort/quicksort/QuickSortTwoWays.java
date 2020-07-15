package sort.quicksort;

import sort.SortTestHelper;
import sort.insertsort.StraightInsertSort;

/**
 * 对于有大量重复值的数组，快速排序会退化为n的平方，可以使用双路快速排序解决。
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class QuickSortTwoWays {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(Comparable[] arr, int l, int r) {
        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            StraightInsertSort.sort(arr, l, r);
            return;
        }
        if (l < r) {
            int keyloc = partition(arr, l, r);
            quickSort(arr, l, keyloc - 1);
            quickSort(arr, keyloc + 1, r);
        }
    }

    public static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable key = arr[l];
        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0,
            // 比如数组 1,0,0, ..., 0, 0
            // a. 对于arr[i]<v和arr[j]>v的方式，第一次partition得到的分点是数组中间；
            // b. 对于arr[i]<=v和arr[j]>=v的方式，第一次partition得到的分点是数组的倒数第二个。
            // 这是因为对于连续出现相等的情况，a方式会交换i和j的值；
            // 而b方式则会将连续出现的这些值归为其中一方，使得两棵子树不平衡。
            while (i <= r && arr[i].compareTo(key) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(key) > 0) {
                j--;
            }
            if (i > j)
                break;
            swap(arr, i, j);
            i++;
            j--;
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
        Integer[] arr = new Integer[20000];
        arr[0] = 1;
        for (int i = 1; i < 20000; i++) {
            arr[i] = 0;
        }
        SortTestHelper.testSort("sort.quicksort.QuickSortTwoWays", arr);
        SortTestHelper.printArray(arr);
    }
}