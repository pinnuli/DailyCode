package the56_数组中数字出现的次数.题目一;

/**
 * author@ pinnuli
 * date@ 2019/3/24
 */
public class Solution2 {
    /**
     * diff &= -diff 得到出 diff 最右侧不为 0 的位，
     * 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
     * 利用这一位就可以将两个元素区分开来。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int resultOfExclusiveOr = 0;
        for (int number : array) {
            resultOfExclusiveOr ^= number;
        }
        resultOfExclusiveOr &= -resultOfExclusiveOr;
        for (int number : array) {
            if ((number & resultOfExclusiveOr) == 0) {
                num1[0] ^= number;
            } else {
                num2[0] ^= number;
            }
        }
    }
}
