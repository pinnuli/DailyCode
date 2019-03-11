package the40_最小的k个数;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * author@ pinnuli
 * date@ 2019/3/11
 */
public class Solution {

    /**
     * 基于快排，时间复杂度为O(n)
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> tetLeastNumbersLikeQuickSort(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k > input.length || k <= 0) {
            return result;
        }
        int start = 0;
        int end = input.length - 1;
        int middle = input.length >> 1;
        int index = partition(input, start, end);
        while(index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
                index = partition(input, start, end);
            }
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (low < high && key <= array[high]) {
                high --;
            }
            array[low] = array[high];
            while (low < high && key >= array[low]) {
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        return low;
    }
}
