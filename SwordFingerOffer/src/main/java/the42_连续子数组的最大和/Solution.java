package the42_连续子数组的最大和;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 * author@ pinnuli
 * date@ 2019/3/17
 */
public class Solution {
    /**
     * 使用数组的规律
     * @param array
     * @return
     */
    public int findgreatestsumofsubarray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : array) {
            if (currentSum <= 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }

            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }
}
