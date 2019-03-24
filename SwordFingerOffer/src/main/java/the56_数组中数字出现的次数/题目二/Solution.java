package the56_数组中数字出现的次数.题目二;

import java.util.Arrays;

/**
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 * author@ pinnuli
 * date@ 2019/3/24
 */
public class Solution {
    public int findNumberAppearingOnce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Invalid input!");
        }

        int[] sumOfbits = new int[32];
        Arrays.fill(sumOfbits, 0);
        for (int number : array) {
            int bitMark = 1;
            for (int i = 31; i >= 0; i--) {
                if ((number & bitMark) != 0) {
                    sumOfbits[i] ++;
                }
                bitMark <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += sumOfbits[i] % 3;
        }
        return result;
    }
}
