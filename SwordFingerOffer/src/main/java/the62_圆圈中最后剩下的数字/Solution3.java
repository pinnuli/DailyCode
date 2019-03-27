package the62_圆圈中最后剩下的数字;

/**
 * author@ pinnuli
 * date@ 2019/3/27
 */
public class Solution3 {
    /**
     * 数学归纳法，使用循环
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
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
