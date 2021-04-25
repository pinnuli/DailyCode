package com.pinnuli.leetcode.num56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author linxiaoyi
 * @date 2021/4/24
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        mergeSort(intervals, 0, intervals.length - 1);
        int[] currentRange = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currentRange[1] >= intervals[i][0]) {
                currentRange = new int[]{currentRange[0], Math.max(intervals[i][1], currentRange[1])};
            } else {
                result.add(currentRange);
                currentRange = intervals[i];
            }
        }
        result.add(currentRange);
        return result.toArray(new int[result.size()][]);
    }


    private void mergeSort(int[][] intervals, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(intervals, p, q);
        mergeSort(intervals, q + 1, r);
        mergeCore(intervals, p, q, r);
    }

    private void mergeCore(int[][] intervals, int left, int mid, int right) {
        int[][] intervalsBak = new int[intervals.length][];
        for (int i = left; i <= right; i++) {
            intervalsBak[i] = intervals[i];
        }
        int i = left, j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (intervalsBak[i][0] < intervalsBak[j][0] || (intervalsBak[i][0] == intervalsBak[j][0] && intervalsBak[i][1] <= intervalsBak[j][1])) {
                intervals[k++] = intervalsBak[i++];
            } else {
                intervals[k++] = intervalsBak[j++];
            }
        }
        while (i <= mid) {
            intervals[k++] = intervalsBak[i++];
        }
        while (j <= right) {
            intervals[k++] = intervalsBak[j++];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {2, 3}})));
    }
}
