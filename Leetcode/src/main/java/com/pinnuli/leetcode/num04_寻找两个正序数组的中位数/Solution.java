package com.pinnuli.leetcode.num04_寻找两个正序数组的中位数;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 *
 * @author linxiaoyi
 * @date 2021/4/30
 */
public class Solution {

    /**
     * 模拟归并排序，时间复杂度为O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex = (nums2.length + nums1.length) / 2;
        int i = 0, j = 0, k = 0;
        int preNum = 0;
        int currentNum = 0;
        while (i < nums1.length && j < nums2.length && k <= medianIndex) {
            preNum = currentNum;
            if (nums1[i] <= nums2[j]) {
                currentNum = nums1[i];
                i++;
            } else {
                currentNum = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length && k <= medianIndex) {
            preNum = currentNum;
            currentNum = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length && k <= medianIndex) {
            preNum = currentNum;
            currentNum = nums2[j];
            j++;
            k++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return currentNum;
        } else {
            return (currentNum + preNum) / 2d;
        }
    }

    /**
     * 二分查找，时间复杂度未log(m+n)
     */
    public double findMedianSortedArraysBinary(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            int medianIndex1 = totalLength / 2 - 1;
            int medianIndex2 = totalLength / 2;
            return (getKthElement(nums1, nums2, medianIndex1 + 1) + getKthElement(nums1, nums2, medianIndex2 + 1)) / 2.0;
        } else {
            int medianIndex = totalLength / 2;
            return getKthElement(nums1, nums2, medianIndex + 1);
        }
    }


    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0, length1 = nums1.length, length2 = nums2.length;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int midIndex1 = Math.min(index1 + k / 2, length1) - 1;
            int midIndex2 = Math.min(index2 + k / 2, length2) - 1;
            if (nums1[midIndex1] <= nums2[midIndex2]) {
                k -= (midIndex1 - index1 + 1);
                index1 = midIndex1 + 1;
            } else {
                k -= (midIndex2 - index2 + 1);
                index2 = midIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{6, 8, 9}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2, 5, 7}, new int[]{6, 8, 9}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2, 5}, new int[]{6, 8, 9}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

        System.out.println();

        System.out.println(solution.findMedianSortedArraysBinary(new int[]{}, new int[]{6, 8, 9}));
        System.out.println(solution.findMedianSortedArraysBinary(new int[]{2}, new int[]{}));
        System.out.println(solution.findMedianSortedArraysBinary(new int[]{2, 5, 7}, new int[]{6, 8, 9}));
        System.out.println(solution.findMedianSortedArraysBinary(new int[]{2, 5}, new int[]{6, 8, 9}));
        System.out.println(solution.findMedianSortedArraysBinary(new int[]{1, 3}, new int[]{2}));
    }

}
