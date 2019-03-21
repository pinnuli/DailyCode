package the50_第一个只出现一次的字符.题目一;

/**
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution2 {
    /**
     * 虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        int[] times = new int[256];
        for (int i = 0; i < str.length(); i++) {
            times[str.charAt(i)] ++;
        }

        int position = -1;
        for (int i = 0; i < str.length(); i++) {
            if (times[str.charAt(i)] == 1) {
                position = i;
                break;
            }
        }
        return position;
    }
}
