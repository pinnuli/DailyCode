package the48_最长不含重复字符的子字符串;

import java.util.Arrays;

/**
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 * @author: pinnuli
 * @date: 2019-03-20
 */

public class Solution {

    public int longestSubStringWithoutDuplication(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int curLen = 0;
        int maxLen = 0;
        int[] positions = new int[26];
        Arrays.fill(positions, -1);
        for (int i = 0; i < str.length(); i++) {
            int preIndex = positions[str.charAt(i) - 'a'];
            int distance = i - preIndex;
            if (preIndex == -1 || distance > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = distance;
            }
            positions[str.charAt(i) - 'a'] = i;
        }
        return Math.max(maxLen, curLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubStringWithoutDuplication(null));
    }

}
