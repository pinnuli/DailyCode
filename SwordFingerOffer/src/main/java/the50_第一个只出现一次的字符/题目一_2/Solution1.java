package the50_第一个只出现一次的字符.题目一_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个函数，删除字符串中所有重复出现的字符。
 * 例如输入“google”，删除重复的字符之后的结果是“gole”。
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution1 {

    public String deleteRepeatByMap(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                result.append(ch);
            }
        }
        return result.toString();
    }

}
