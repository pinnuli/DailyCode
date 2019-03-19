package the47_礼物的最大价值;

/**
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 * author@ pinnuli
 * date@ 2019/3/19
 */
public class Solution1{

        public int getMost(int[][] board) {
            // write code here
            if (board == null || board.length == 0 || board[0].length == 0) {
                return 0;
            }
            int rows = board.length;
            int cols = board[0].length;
            int[][] maxValues = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int left = 0;
                    int up = 0;
                    if (row > 0) {
                        up = maxValues[row - 1][col];
                    }
                    if (col > 0) {
                        left = maxValues[row][col - 1];
                    }
                    maxValues[row][col] = Math.max(left, up) + board[row][col];
                }
            }
            return maxValues[rows - 1][cols - 1];
        }

        public static void main(String[] args) {
            Solution1 solution = new Solution1();
            int[][] board = new int[][]{{426,306,641,372,477,409},{223,172,327,586,363,553},{292,645,248,316,711,295},{127,192,495,208,547,175},{131,448,178,264,207,676},{655,407,309,358,246,714}};
            System.out.println(solution.getMost(board));
        }
}
