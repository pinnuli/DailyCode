package the62_圆圈中最后剩下的数字;

/**
 * author@ pinnuli
 * date@ 2019/3/27
 */
public class Solution2 {
    /**
     * 数学归纳法，使用递归
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m ) % n;
    }
}
