package com.pinnuli.leetcode.num394_字符串解码;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author linxiaoyi
 * @date 2021/4/12
 */
public class Solution {

    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public static String decodeString(String s) {
        Stack<Character> charStack = new Stack();
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '[') {
                charStack.push(c);
            } else {
                StringBuilder repeatStr = new StringBuilder();
                while (!charStack.isEmpty()) {
                    char top = charStack.pop();
                    if (top != ']') {
                        repeatStr.append(top);
                    } else {
                        int repeatCount = 0;
                        int base = 1;
                        while (i - 1 >= 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                            repeatCount += (s.charAt(--i) - '0') * base;
                            base *= 10;
                        }
                        for (int j = 0; j < repeatCount; j++) {
                            for (int k = repeatStr.length() - 1; k >= 0; k--) {
                                charStack.push(repeatStr.charAt(k));
                            }
                        }
                        break;
                    }
                }
            }
        }
        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]10[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("abc"));
        System.out.println(decodeString("10[a]abc"));
    }
}
