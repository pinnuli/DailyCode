package the15_二进制中1的个数;

/**
 * @author: pinnuli
 * @date: 2019-02-17
 */

public class Solution {

    public int solution1(int number) {
         int count = 0;
        while (number != 0) {
            if ((number & 1) != 0) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public int solution2(int number) {
        int count = 0;
        int flag = 1;
        while (number != 0) {
            if ((number & 1) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public int solution3(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = (number-1) & number;
        }
        return count;
    }
}
