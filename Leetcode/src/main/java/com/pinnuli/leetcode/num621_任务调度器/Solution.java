package com.pinnuli.leetcode.num621_任务调度器;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间 。
 *
 * @author linxiaoyi
 * @date 2021/4/15
 */
public class Solution {

    // 贪心算法
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskStatistics = new HashMap<Character, Integer>();
        for (char task : tasks) {
            taskStatistics.put(task, taskStatistics.getOrDefault(task, 0) + 1);
        }
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> restCount = new ArrayList<>();
        int m = taskStatistics.size();

        for (Map.Entry entry : taskStatistics.entrySet()) {
            nextValid.add(1);
            restCount.add((Integer) entry.getValue());
        }

        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (restCount.get(j) != 0) {
                    minValue = Math.min(nextValid.get(j), minValue);
                }
            }
            time = Math.max(time, minValue);
            int best = -1;
            for (int k = 0; k < m; k++) {
                if (restCount.get(k) != 0 && nextValid.get(k) <= time) {
                    if (best == -1 || restCount.get(k) > restCount.get(best)) {
                        best = k;
                    }
                }
            }
            restCount.set(best, restCount.get(best) - 1);
            nextValid.set(best, time + n + 1);
        }
        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'},2));
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'},0));
        System.out.println(solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
    }

}
