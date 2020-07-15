package the4_二维数组中的查找;

import java.util.Scanner;

/**
 * @author: pinnuli
 * @date: 2018-11-17
 */


public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入行数：");
        int rowCount = s.nextInt();
        System.out.println("请输入列数：");
        int colCount = s.nextInt();
        System.out.println("请输入数组");
        int[][] array = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                array[i][j] = s.nextInt();
            }
        }
        System.out.println("请输入目标数字：");
        int target = s.nextInt();
        System.out.println("目标数字" + (find(target, array) ? "存在" : "不存在"));
    }

    private static boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
