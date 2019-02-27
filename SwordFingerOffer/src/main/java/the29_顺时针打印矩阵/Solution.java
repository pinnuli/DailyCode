package the29_顺时针打印矩阵;

import java.util.ArrayList;

/**
 * @author: pinnuli
 * @date: 2019-02-27
 */

public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int i = col1; i <= col2; i++) {
                result.add(matrix[row1][i]);
            }

            for (int i = row1 + 1; i <= row2; i++) {
                result.add(matrix[i][col2]);
            }

            if (row1 < row2) {
                for (int i = col2 - 1; i >= col1; i--) {
                    result.add(matrix[row2][i]);
                }
            }

            if (col1 < col2) {
                for (int i = row2 - 1; i > row1; i--) {
                    result.add(matrix[i][col1]);
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        return result;
    }

}
