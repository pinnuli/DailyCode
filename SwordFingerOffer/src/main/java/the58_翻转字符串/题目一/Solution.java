package the58_翻转字符串.题目一;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverseSentence(chars, 0, chars.length - 1);
        int start = 0;
        int end = 0;
        while(end <= chars.length) {
            if (end == chars.length || chars[end] == ' ') {
                reverseSentence(chars, start, end - 1);
                start = end + 1;
            }
            end ++;
        }
        return new String(chars);
    }

    private void reverseSentence(char[] chars, int start, int end) {
        while(start < end) {
            swap(chars, start++, end--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
