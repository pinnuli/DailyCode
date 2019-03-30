package the67_把字符串转换成整数;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * author@ pinnuli
 * date@ 2019/3/30
 */
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isNegative = str.charAt(0) == '-';
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-')) {
                continue;
            }
            if (ch < '0' || ch > '9') {
                return 0;
            }
            result = result * 10 + (ch - '0');
        }
        return isNegative ? -result : result;
    }
}
