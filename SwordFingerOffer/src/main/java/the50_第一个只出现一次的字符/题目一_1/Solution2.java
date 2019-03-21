package the50_第一个只出现一次的字符.题目一_1;

import java.util.BitSet;

/**
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution2 {
    /**
     * 使用BitsSet来保存
     * @param str1
     * @param str2
     * @return
     */
    public String deleteFirstExistSecondByBitSet(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return str1;
        }

        BitSet bs = new BitSet(256);
        for (char ch : str2.toCharArray()) {
            bs.set(ch);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : str1.toCharArray()) {
            if (!bs.get(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
