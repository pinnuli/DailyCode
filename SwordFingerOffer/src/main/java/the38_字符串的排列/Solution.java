package the38_字符串的排列;

import java.util.ArrayList;
import java.util.Collections;

/**
 * author@ pinnuli
 * date@ 2019/3/10
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() <= 0) {
            return result;
        }
        permutationHelper(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }

    private void permutationHelper(char[] charArray, int index, ArrayList<String> list) {
        if (index == charArray.length - 1) {
            String val = String.valueOf(charArray);
            if (!list.contains(val)) {
                list.add(val);
            }
        }
        for (int i = index; i < charArray.length; i++) {
            swap(charArray, index, i);
            permutationHelper(charArray, index + 1, list);
            swap(charArray, index, i);
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
