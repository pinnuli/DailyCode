package the50_第一个只出现一次的字符.题目一;

import java.util.BitSet;

/**
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution3 {
    /**
     * 考虑到只需要找到只出现一次的字符，
     * 那么需要统计的次数信息只有 0,1,更大，
     * 使用两个比特位就能存储这些信息，
     * 达到空间复杂度最优。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        BitSet bitset1 = new BitSet(256);
        BitSet bitset2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bitset1.get(c) && !bitset2.get(c)) {
                bitset1.set(c);
            } else if (bitset1.get(c) && !bitset2.get(c)) {
                bitset2.set(c);
            }
        }

        int position = -1;
        for (int i = 0; i < str.length(); i++) {
            if (bitset1.get(str.charAt(i)) && !bitset2.get(str.charAt(i))) {
                position = i;
                break;
            }
        }
        return position;
    }
}
