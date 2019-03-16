
package the12_矩阵中的路径;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Scanner;

/**
 * Solution1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 16, 2019</pre>
 */
public class SolutionTest {
    /**
     * Method: hasPath(char[] matrix, int rows, int cols, char[] str)
     */
    @Test
    public void testHasPath() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵行数：");
        int rows = scanner.nextInt();
        System.out.println(rows);
        System.out.println("请输入矩阵列数：");
        int cols = scanner.nextInt();
        char[] matrix = new char[rows * cols];
        System.out.println("请输入矩阵：");
        String matrixTemp = scanner.next();
        matrix = matrixTemp.toCharArray();

        System.out.println("请输入要查找的字符串长度：");
        int strLength = scanner.nextInt();
        char[] str = new char[strLength];
        String strTemp = scanner.next();
        str = strTemp.toCharArray();

        Solution solution = new Solution();
        System.out.println(solution.hasPath(matrix, rows, cols, str));
    }


} 
