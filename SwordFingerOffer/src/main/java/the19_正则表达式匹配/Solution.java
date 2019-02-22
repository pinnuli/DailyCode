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

    public boolean matchDp(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        int strLength = str.length;
        int patLength = pattern.length;
        boolean[][] dp = new boolean[strLength + 1][patLength + 1];

        //表示空串匹配成功
        dp[strLength][patLength] = true;

        for (int i = strLength; i >= 0; i--) {
            for (int j = patLength - 1; j >=0 ; j--) {
                if (j < patLength - 1 && pattern[j + 1] == '*') {
                    if (i < strLength && (str[i] == pattern[j] || pattern[j] == '.')) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 2];
                    } else {
                        dp[i][j] = dp[i][j + 2];
                    }
                } else {
                    if (i != strLength && (str[i] == pattern[j] || pattern[j] == '.')) {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
