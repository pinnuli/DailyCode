package the53_数字在排序数组中出现的次数.题目三_数组中数值和下标相等的元素;

/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
 * author@ pinnuli
 * date@ 2019/3/23
 */
public class Solution {

    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 2;
            if (array[middle] == middle) {
                return middle;
            } else if (array[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
