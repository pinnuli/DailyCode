package com.pinnuli.leetcode.num03_最长子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: pinnuli
 * @date: 2018-12-08
 */

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        List<Character> charArray = new ArrayList<Character>();
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
            maxLength = Math.max(maxLength, charArray.size());
        }
        return maxLength;
    }

    public static int slideWindow(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap();
        int maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j ++) {
            if (charMap.containsKey(s.charAt(j))) {
                i = Math.max(charMap.get(s.charAt(j)) + 1, i);
            }
            maxLength = Math.max(j - i + 1, maxLength);
            charMap.put(s.charAt(j), j);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringUseMap(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i ++) {
            charMap.clear();
            for (int j = i; j < s.length(); j ++) {
                charMap.put(s.charAt(j), 0);
                if (charMap.keySet().size() < j - i + 1) {
                    break;
                }
            }
            maxLength = Math.max(charMap.keySet().size(), maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringUseMap("pwwkew"));
    }
}
