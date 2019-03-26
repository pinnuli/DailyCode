package the60_n个骰子的点数;

/**
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution2 {

    /**
     * 使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
     * 空间复杂度：O(N2)
     */

    final int MAX_VALUE = 6;

    public void printProbablity(int count) {
        int maxSum = MAX_VALUE * count;
        int[][] dp = new int[count + 1][maxSum + 1];
        for (int i = 1; i <= MAX_VALUE; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= count; i++) {
            for (int j = i; j <= i * MAX_VALUE; j++) {
                for (int k = 1; k <= MAX_VALUE && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        int totalTimes = (int)Math.pow(MAX_VALUE, count);
        for (int i = count; i <= maxSum; i++) {
            double ratio = (double)dp[count][i] / totalTimes;
            System.out.println(i  + ": " + ratio);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.printProbablity(2);
    }
}
