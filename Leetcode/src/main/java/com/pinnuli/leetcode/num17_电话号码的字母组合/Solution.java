package com.pinnuli.leetcode.num17_电话号码的字母组合;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author linxiaoyi
 * @date 2021/4/19
 */
public class Solution {

    public static Map<Integer, char[]> digitToLetterMap = new HashMap<>();
    static {
        digitToLetterMap.put(2, new char[]{'a', 'b', 'c'});
        digitToLetterMap.put(3, new char[]{'d', 'e', 'f'});
        digitToLetterMap.put(4, new char[]{'g', 'h', 'i'});
        digitToLetterMap.put(5, new char[]{'j', 'k', 'l'});
        digitToLetterMap.put(6, new char[]{'m', 'n', 'o'});
        digitToLetterMap.put(7, new char[]{'p', 'q', 'r', 's'});
        digitToLetterMap.put(8, new char[]{'t', 'u', 'v'});
        digitToLetterMap.put(9, new char[]{'w', 'x', 'y', 'z'});
    }


    // 时间复杂度：O(3^M×4^N)。M是对应三个字母的数字个数，N是对应四个字母的数字个数。
    public List<String> letterCombinationsByQueue(String digits) {
        LinkedList<String> targetResult = new LinkedList<>();
        if (digits.length() <= 0) {
            return targetResult;
        }
        targetResult.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            char[] letters = digitToLetterMap.get(digit);
            int targetSize = targetResult.size();
            for (int j = 0; j < targetSize; j++){
                String lastStr = targetResult.poll();
                for (int k = 0; k < letters.length; k++) {
                    targetResult.offer(lastStr + letters[k]);
                }
            }
        }
        return targetResult;
    }

    /**
     * 时间复杂度：O(3^m \times 4^n)，其中m是输入中对应3个字母的数字个数（包括数字2、3、4、5、6、8），
     * n是输入中对应4个字母的数字个数（包括数字 7、9），m+n是输入数字的总个数。
     * 当输入包含m个对应3个字母的数字和n个对应4个字母的数字时，不同的字母组合一共有 3^m * 4^n3 种，需要遍历每一种字母组合。
     * 空间复杂度：O(n)
     */
    public List<String> letterCombinationsByRecursion(String digits) {
        return letterCombinationsCore(new ArrayList<>(), digits);
    }

    private List<String> letterCombinationsCore(List<String> result, String digits) {
        if (digits.length() <= 0) return result;
        List<String> combineResult = new ArrayList<>();
        int digit = digits.charAt(0) - '0';
        char[] letters = digitToLetterMap.get(digit);
        if (result.isEmpty()) {
            for (char letter : letters) {
                combineResult.add(letter + "");
            }
        } else {
            for (String s : result) {
                for (char letter : letters) {
                    combineResult.add(s + letter);
                }
            }
        }
        return letterCombinationsCore(combineResult, digits.substring(1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.letterCombinationsByQueue("23"));
        System.out.println(solution.letterCombinationsByQueue(""));
        System.out.println(solution.letterCombinationsByQueue("239"));

        System.out.println(solution.letterCombinationsByRecursion("22"));
        System.out.println(solution.letterCombinationsByRecursion(""));
        System.out.println(solution.letterCombinationsByRecursion("239"));
    }

}
