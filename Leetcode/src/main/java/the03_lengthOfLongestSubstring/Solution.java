package the03_lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 2018-12-08
 */

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        ArrayList charArray = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++){
            charArray.clear();
            charArray.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++) {
                if (!charArray.contains(s.charAt(j))) {
                    charArray.add(s.charAt(j));
                } else {
                    break;
                }
            }
            maxLength = maxLength > charArray.size() ? maxLength : charArray.size();
        }
        return maxLength;
    }

    public static int slideWindow(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0,  j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
