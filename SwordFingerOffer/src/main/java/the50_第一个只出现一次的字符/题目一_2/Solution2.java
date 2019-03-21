package the50_第一个只出现一次的字符.题目一_2;

import java.util.BitSet;

/**
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution2 {

    public String deleteRepeatByBitSet(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        BitSet bs = new BitSet(256);
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!bs.get(ch)) {
                result.append(ch);
                bs.set(ch);
            }
        }
        return result.toString();
    }
}
