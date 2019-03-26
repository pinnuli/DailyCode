package the60_n个骰子的点数;

import java.util.Arrays;

/**
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s，输入n，打印出s的所有可能的值出现的概率。
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution1 {
    /**
     * 使用递归，但是效率太低
     */
    final int MAX_VALUE = 6;

    public void printProbablity(int count) {
        if (count < 1) {
            return;
        }

        int maxSum = count * MAX_VALUE;
        int[] times = new int[maxSum - count + 1];
        probablity(count, MAX_VALUE, 0, times);
        int totalTimes = (int)Math.pow(MAX_VALUE, count);
        for (int i = count; i <= maxSum; i++) {
            double ratio = (double)times[i - count] / totalTimes;
            System.out.println(i  + ": " + ratio);
        }

    }

    private void probablity(int count, int current, int sum, int[] times) {
        if (current == 0) {
            times[sum - count]++;
        } else {
            for (int i = 1; i <= MAX_VALUE; i++) {
                probablity(count, current - 1, i + sum, times);
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.printProbablity(2);
    }
}
