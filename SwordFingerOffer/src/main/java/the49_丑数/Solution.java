package the49_丑数;

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数。
 * @author: pinnuli
 * @date: 2019-03-20
 */

public class Solution {
    /**
     * 这里定义了一个数组来保存丑数，从而可以实现只计算丑数，避免了非丑数的计算，以空间换时间
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglys = new int[index];
        uglys[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < index; i++) {
            int next2 = uglys[index2] * 2, next3 = uglys[index3] * 3, next5 = uglys[index5] * 5;
            uglys[i] = Math.min(next2, Math.min(next3, next5));
            if (uglys[i] == next2) {
                index2 ++;
            }
            if (uglys[i] == next3) {
                index3 ++;
            }
            if (uglys[i] == next5) {
                index5 ++;
            }
        }
        return uglys[index - 1];
    }
}
