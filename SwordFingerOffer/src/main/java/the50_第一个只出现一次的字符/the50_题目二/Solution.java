package the50_第一个只出现一次的字符.the50_题目二;

import java.util.Arrays;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是’g’。
 * 当从该字符流中读出前六个字符”google”时，第一个只出现一次的字符是’l’。
 * @author: pinnuli
 * @date: 2019-03-21
 */

public class Solution {
    /**
     * 每从字符流中读入一个字符，
     * 若该字符没有重复，则记录该字符读入的位置；
     * 若该字符在之前已经被读入过，则忽略该字符;
     * 最后，从记录中找出最早出现的非重复字符。
     * 可以使用数组来记录字符读入位置。
     */

    private int index;
    private int[] occurrence;

    public Solution() {
        index = 0;
        occurrence = new int[256];
        Arrays.fill(occurrence, -1);
    }


    public void insert(char ch) {
        if (occurrence[ch] == -1) {
            occurrence[ch] = index;
        } else if (occurrence[ch] >= 0){
            occurrence[ch] = -2;
        }
        index ++;
    }

    public char getFirstAppearOnce() {
        int minIndex = Integer.MAX_VALUE;
        char result = '\0';
        for (int i = 0; i < 256; i++) {
            if (occurrence[i] >= 0 && minIndex > occurrence[i]) {
                minIndex = occurrence[i];
                result = (char)i;
            }
        }
        return result;
    }
}
