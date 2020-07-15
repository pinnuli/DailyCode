package sort.mergesort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * 使用归并排序求逆序对
 *
 * @author linxiaoyi
 * @date 2020/5/24
 */
public class InversionNumberByMergeaSort {

    // merge函数求出在arr[l...mid]和arr[mid+1...r]有序的基础上, arr[l...r]的逆序数对个数
    private static long merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        long result = 0L;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {// 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {// 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) <= 0) {// 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {// 右半部分所指元素 < 左半部分所指元素，
                // 此时, 因为右半部分k所指的元素小，这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                arr[k] = aux[j - l];
                j++;
                result += mid - l + 1;
            }
        }
        return result;
    }

    private static long solve(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return 0L;
        }
        int mid = l + (r - l) / 2;
        long res1 = solve(arr, l, mid);
        long res2 = solve(arr, mid + 1, r);
        return res1 + res2 + merge(arr, l, mid, r);
    }

    private static long solve(Comparable[] arr) {
        return solve(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int N = 1000000;

        // 测试1: 测试随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " :" + solve(arr) );

        // 测试2: 测试完全有序的数组
        // 结果应该为0
        arr = SortTestHelper.generateOrderedArray(N);
        System.out.println("Test Inversion Count for Ordered Array, n = " + N + " :" + solve(arr) );

        // 测试3: 测试完全逆序的数组
        // 结果应改为 N*(N-1)/2
        arr = SortTestHelper.generateInversedArray(N);
        System.out.println("Test Inversion Count for Inversed Array, n = " + N + " :" + solve(arr) );

    }
}
