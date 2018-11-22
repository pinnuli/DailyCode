package the2_replaceSpace;

/**
 * @author: pinnuli
 * @date: 2018-11-17
 */

public class Solution {
    public String replaceSpace(StringBuffer str) {
        int l = str.toString().length();
        for(int i = 0; i < l; i++) {
            if(" ".equals(str.charAt(i))) {
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }
}
