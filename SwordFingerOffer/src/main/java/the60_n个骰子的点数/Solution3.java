package the60_n个骰子的点数;

/**
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution3 {
    /**
     * 动态规划解法 + 旋转数组
     * 空间复杂度：O(N)
     */

    final int MAX_VALUE = 6;

    public void printProbablity(int count) {
        int maxSum = MAX_VALUE * count;
        int[][] dp = new int[2][maxSum + 1];
        for (int i = 1; i <= MAX_VALUE; i++) {
            dp[0][i] = 1;
        }
        int flag = 1;
        for (int i = 2; i <= count; i++, flag = 1 - flag) {
            for (int j = 0; j <= maxSum; j++) {
                dp[flag][j] = 0;
            }

            for (int j = i; j <= i * MAX_VALUE; j++) {
                for (int k = 1; k <= MAX_VALUE && k <= j; k++) {
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }

        int totalTimes = (int)Math.pow(MAX_VALUE, count);
        for (int i = count; i <= maxSum; i++) {
            double ratio = (double)dp[1 - flag][i] / totalTimes;
            System.out.println(i  + ": " + ratio);
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.printProbablity(2);
    }
}
