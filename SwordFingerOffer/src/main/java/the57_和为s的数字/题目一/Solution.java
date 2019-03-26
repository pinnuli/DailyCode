package the57_和为s的数字.题目一;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * author@ pinnuli
 * date@ 2019/3/25
 */
public class Solution {
    /**
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int ahead = 0;
        int behind = array.length - 1;
        while (ahead < behind) {
            if (array[ahead] + array[behind] == sum) {
                result.add(array[ahead]);
                result.add(array[behind]);
                return result;
            } else if (array[ahead] + array[behind] > sum) {
                behind --;
            } else {
                ahead ++;
            }
        }
        return result;
    }
}
