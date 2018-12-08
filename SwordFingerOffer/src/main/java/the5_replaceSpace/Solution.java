package the5_replaceSpace;

/**
 * @author: pinnuli
 * @date: 2018-11-17
 */

public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer newString = new StringBuffer();
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

}
