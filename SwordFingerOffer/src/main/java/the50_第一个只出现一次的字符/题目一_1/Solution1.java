package the50_第一个只出现一次的字符.题目一_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 从第一个字符串中删除在第二个字符串中出现过的所有字符，
 * 例如，从第一个字符串”We are students.”
 * 中删除在第二个字符串”aeiou”中出现过的字符得到的结果是“W r stdnts.”。
 *
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution1 {

    /**
     * 使用HashMap存储str2中出现的字符
     * @param str1
     * @param str2
     * @return
     */
    public String deleteFirstExistSecondByMap(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return str1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str2.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : str1.toCharArray()) {
            if (!map.containsKey(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }



}
