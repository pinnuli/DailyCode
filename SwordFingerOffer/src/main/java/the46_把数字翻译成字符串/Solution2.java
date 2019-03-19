package the46_把数字翻译成字符串;

/**
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * author@ pinnuli
 * date@ 2019/3/19
 */
public class Solution2 {

    /**
     * 递归可能会导致重复计算子问题，比如12558，先分为1和2558或者12和558，
     * 那么接下来计算前面的2558，就会分为2 和558，重复计算了558，
     * 使用循环，从末尾开始算起，避免了重复子问题，速度快于递归。
     * @param number
     * @return
     */
    public int getTranslationCount(String number) {
        if (number == null || number.length() == 0) {
            return -1;
        }

        char[] num = number.toCharArray();
        int count;
        int[] counts = new int[num.length];
        for (int i = num.length - 1; i >= 0; i--) {
            if (i < num.length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            if (i < num.length - 1) {
                int converted = (num[i] - '0') * 10 + (num[i + 1] - '0');
                if (converted >= 10 && converted <= 25) {
                    if (i < num.length - 2) {
                        count += counts[i + 2];
                    } else {
                        count ++;
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.getTranslationCount("25262526"));
    }
}
