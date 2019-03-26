package the58_翻转字符串.题目二;

/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution {
    /**
     * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0 || n > str.length()) {
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            swap(chars, start++, end--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
