package the19_正则表达式匹配;


/**
 * @author: pinnuli
 * @date: 2019-02-21
 */

public class Solution {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    public boolean matchCore(char[] str, char[] pattern, int strIndex, int patIndex) {
        if (str.length == strIndex && pattern.length == patIndex) {
            return true;
        }

        if (str.length != strIndex && pattern.length == patIndex) {
            return false;
        }

        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            if ((str.length != strIndex && str[strIndex] == pattern[patIndex] )
                    || (str.length != strIndex && pattern[patIndex] == '.')) {
                return matchCore(str, pattern, strIndex + 1, patIndex + 2)
                        || matchCore(str, pattern, strIndex + 1, patIndex)
                        || matchCore(str, pattern, strIndex, patIndex + 2);
            } else {
                return matchCore(str, pattern, strIndex, patIndex + 2);
            }
        }

        if ((str.length != strIndex && str[strIndex] == pattern[patIndex])
                || (pattern[patIndex] == '.' && str.length != strIndex)) {
            return matchCore(str, pattern,strIndex + 1, patIndex +1);
        }
        return false;
    }
}
