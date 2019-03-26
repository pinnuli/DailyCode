package the59_队列的最大值.题目一;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution1 {
    /**
     * 使用一个双端队列
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size < 1 || size > num.length) {
            return result;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int begin = 0;
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (queue.isEmpty()) {
                queue.add(i);
            } else if (begin > queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (begin >= 0) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }
}
