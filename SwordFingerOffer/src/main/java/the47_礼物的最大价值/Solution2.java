package the47_礼物的最大价值;

/**
 * author@ pinnuli
 * date@ 2019/3/19
 */
public class Solution2 {
    public int getMost(int[][] board) {
        // write code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int rows = board.length;
        int cols = board[0].length;
        int[] maxValues = new int[cols];
        for (int row = 0; row < rows; row++) {
            maxValues[0] += board[row][0];
            for (int col = 1; col < cols; col++) {
                maxValues[col] = Math.max(maxValues[col - 1], maxValues[col]) + board[row][col];
            }
        }
        return maxValues[cols - 1];
    }
}
