package the12_矩阵中的路径;

import java.util.Scanner;

/**
 * @author: pinnuli
 * @date: 2019-02-16
 */

public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length <= 0 || rows <= 0 || cols <= 0 || str.length <= 0) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hashPathCore(matrix, rows, cols, row, col, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hashPathCore(char[] matrix, int rows, int cols, int row, int col,
                                char[] str, int pathLength, boolean[] visited) {
        if (str.length == pathLength) {
            return true;
        }
        boolean hasPath = false;
        int index = row * cols + col;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[index] == str[pathLength]
                && !visited[index]) {
            visited[index] = true;

            hasPath = hashPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, visited)
                    || hashPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, visited)
                    || hashPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, visited)
                    || hashPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, visited);

            if (!hasPath) {
                visited[index] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵行数：");
        int rows = scanner.nextInt();
        System.out.println("请输入矩阵列数：");
        int cols = scanner.nextInt();
        char[] matrix = new char[rows * cols];
        System.out.println("请输入矩阵：");
        String matrixTemp = scanner.next();
        matrix = matrixTemp.toCharArray();

        while (true){
            System.out.println("请输入要查找的字符串长度：");
            char[] str;
            String strTemp = scanner.next();
            str = strTemp.toCharArray();

            Solution solution = new Solution();
            System.out.println(solution.hasPath(matrix, rows, cols, str));
        }
    }
}
