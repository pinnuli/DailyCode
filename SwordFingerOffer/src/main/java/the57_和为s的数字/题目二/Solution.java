package the57_和为s的数字.题目二;

import java.util.ArrayList;

/**
 * 输出所有和为S的正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序。
 * author@ pinnuli
 * date@ 2019/3/25
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int middle = (sum + 1) / 2;
        while (small < middle) {
            if (curSum > sum) {
                curSum -= small;
                small ++;
            } else if (curSum < sum) {
                big ++;
                curSum += big;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                curSum -= small;
                small ++;
                big ++;
                curSum += big;
            }
        }
        return result;
    }

}
