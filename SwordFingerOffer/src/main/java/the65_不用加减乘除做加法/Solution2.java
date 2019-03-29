package the65_不用加减乘除做加法;

/**
 * author@ pinnuli
 * date@ 2019/3/29
 */
public class Solution2 {
    /**
     * 使用循环
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while(carry != 0);
        return sum;
    }
}
