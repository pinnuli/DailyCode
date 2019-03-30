package the3_数组中重复的数字.题目二;

/**
 * 不修改数组找出重复的数字：
 * 在一个长度为n + 1的数组里的所有数字都在1到n的范围内。
 * 所以数组中至少有一个数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * author@ pinnuli
 * date@ 2019/3/30
 */
public class Solution {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        int start = 1;
        int end = length;
        while (end >= start) {
            int middle = (start + end) >> 2;
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if (count > 1) {
                    duplication[0] = start;
                    return true;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    private int countRange(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] >= end) {
                count++;
            }
        }
        return count;
    }
}
