package the56_数组中数字出现的次数.题目一;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数将num1[0],num2[0]设置为返回结果
 * author@ pinnuli
 * date@ 2019/3/24
 */
public class Solution1 {
    /** 从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或的结果。
     * 因为其他数字都出现两次，在异或中全部抵消了。
     * 由于这两个数字肯定不一样，那么异或的结果肯定不为0，也就是说在这个结果数字的二进制表示中至少有一位为1.
     * 我们在结果数字中找到最右边为1的位的位置，记为第n位。
     * 现在我们以第n位是不是1为标准把原数组中的数字分成两个子数组，
     * 第一个子数组中的每个数字的第n位都是1，而第二个子数组中每个数字的第n位都为0.
     * 由于我们分组的标准是数字中的某一位是1还是0，那么出现了两次的数字肯定被分配到同一个子数组中。
     * 因为两个相同的数字的任意一位都是相同的，我们不可能把两个相同的数字分配到两个子数组中去，
     * 于是我们已经把原数组分成了两个子数组，每个子数组都包含了一个只出现一次的数字，而其他数字都出现了两次。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int resultOfExclusiveOr = 0;
        for (int number : array) {
            resultOfExclusiveOr ^= number;
        }
        int bitIndex = findFirstBitIs1(resultOfExclusiveOr);
        for (int number : array) {
            if (isBit1(number, bitIndex)) {
                num1[0] ^= number;
            } else {
                num2[0] ^= number;
            }
        }
    }

    private int findFirstBitIs1(int number) {
        int bitIndex = 0;
        while ((number & 1) != 1) {
            number >>= 1;
            bitIndex ++;
        }
        return bitIndex;
    }

    private boolean isBit1(int number, int bitIndex) {
        number >>= bitIndex;
        return (number & 1) == 1;
    }
}
