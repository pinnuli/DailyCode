package the53_数字在排序数组中出现的次数.题目二_0到n减1中缺失的数;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 * 在范围0~n-1内的n个数字中有且只有一个数字不再该数组中，请找出这个数字。
 * author@ pinnuli
 * date@ 2019/3/23
 */
public class Solution {
    public int getMissingNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 2;
            if (numbers[middle] != middle) {
                if (middle == 0 || numbers[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left == numbers.length) {
            return left;
        }
        return -1;
    }
}
