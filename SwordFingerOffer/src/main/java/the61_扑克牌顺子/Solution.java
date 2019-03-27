package the61_扑克牌顺子;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽取5张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的2-10位数字本身，
 * A为1，J为11，Q为12，K为13，而大小王可以看成任意数
 * author@ pinnuli
 * date@ 2019/3/27
 */
public class Solution {

    /**
     * 大小王是特殊的数字，我们不妨把他们定义为0，这样就能和其他牌区分开来了。
     * 接下来我们分析判断5个数字是不是连续的，最直观的方法是把数组排序。
     * 值得注意的是，由于0可以当成任意的数字，我们可以用0去补满数组中的空缺。
     * 如果排序之后的数组不是连续的，即相邻的两个数字像个若干个数字，
     * 但只要我们有足够的0可以补满这两个空缺的数字，这个数组实际上还是连续的。
     * 举个例子，数组排序之后为｛0，1，3，4，5｝，
     * 在1和3之间空缺一个2，刚好我们有一个0，也就是我们可以把它当成2去填补这个空缺。
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);
        int countOfZero = 0;
        int countOfGap = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            countOfZero++;
        }
        int small = countOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            countOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big ++;
        }
        return countOfZero >= countOfGap ? true : false;
    }
}
