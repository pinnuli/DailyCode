package com.pinnuli.leetcode.num75_颜色分类;

import java.util.Arrays;

/**
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * @author linxiaoyi
 * @date 2021/4/26
 */
public class Solution {

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i < nums.length && p0 <= p2; i++) {
            while (nums[i] == 2 && i <= p2) {
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2 --;
            }
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0 ++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 2, 1, 0, 2};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
