package the20_表示数值的字符串;

/**
 * @author: pinnuli
 * @date: 2019-02-22
 */

public class Solution {

    private int index;

    public boolean isNumeric(char[] str) {
        if (str.length < 1) {
            return false;
        }

        index = 0;
        boolean numeric = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index ++;
            numeric = scanUnsignedInteger(str) || numeric;
        }

        if (index < str.length && (str[index] == 'e' || str[index] == 'e')) {
            index ++;
            numeric = numeric && scanInteger(str);
        }

        return numeric && index == str.length;
    }

    public boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index ++;
        }
        return scanUnsignedInteger(str);
    }

    public boolean scanUnsignedInteger(char[] str) {
        int begin = index;
        while (index < str.length && str[index] <= '9' && str[index] >= '0') {
            index ++;
        }
        return index > begin;
    }
}
