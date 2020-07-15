package the5_替换空格;

/**
 * @author: pinnuli
 * @date: 2018-11-17
 */

public class Solution {
    /**
     * O(n^2)实现方法
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuilder str) {
        if (str == null) {
            return null;
        }
        StringBuilder newString = new StringBuilder();
        char[] charArray = str.toString().toCharArray();
        for (char c : charArray) {
            if (c == ' ') {
                newString.append("%20");
            } else {
                newString.append(c);
            }
        }
        return newString.toString();
    }

    public String replaceBlank(StringBuffer str) {
        if (str.length() <= 0) {
            return "";
        }
        int numberOfBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                numberOfBlank++;
            }
        }
        int indexOfOriginal = str.length() - 1;
        int newLength = str.length() + numberOfBlank * 2;
        str.setLength(newLength);
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (str.charAt(indexOfOriginal) == ' ') {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            } else {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
            indexOfOriginal--;
        }
        return str.toString();
    }

    public String replaceSpace2(StringBuilder str) {
        if (str == null) {
            return null;
        }
        int indexOld = str.length() - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int indexNew = str.length() - 1;
        while (indexOld >= 0 && indexNew > indexOld) {
            char c = str.charAt(indexOld--);
            if (c == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, c);
            }
        }
        return str.toString();
    }
}
