package the46_把数字翻译成字符串;

/**
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * author@ pinnuli
 * date@ 2019/3/19
 */
public class Solution1 {

    /**
     * 使用递归
     * @param number
     * @return
     */
    public int getTranslationCount(String number) {
        if (number == null || number.length() == 0) {
            return -1;
        }
        return getTranslationCount(number.toCharArray(), 0);
    }

    private int getTranslationCount(char[] number, int index) {
        if (index>= number.length - 1) {
            return 1;
        }

        return getTranslationCount(number, index + 1) + getIsLetter(number, index) * getTranslationCount(number, index + 2);
    }

    private int getIsLetter(char[] number, int index) {
        if (index + 1 < number.length) {
            int converted = (number[index] - '0') * 10 + (number[index + 1] - '0');
            if (converted >= 10 && converted <= 25) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.getTranslationCount("25262526"));
    }

}
