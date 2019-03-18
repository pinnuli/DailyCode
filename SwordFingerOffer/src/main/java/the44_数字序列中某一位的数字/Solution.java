package the44_数字序列中某一位的数字;

/**
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，
 * 求这个字符串的第 index 位, index从第0位算起。
 * @author: pinnuli
 * @date: 2019-03-18
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.digitAtIndex(1001));
    }

    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            int count = countOfDigits(digits);
            if (index < count * digits) {
                return digitAtIndex(index, digits);
            }
            index -= digits * count;
            digits ++;
        }
    }


    private int countOfDigits(int digits) {
        if (digits == 1) {
            return 10;
        }
        return 9 * (int)Math.pow(10, digits - 1);
    }

    private int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int)Math.pow(10, digits - 1);
    }
}
