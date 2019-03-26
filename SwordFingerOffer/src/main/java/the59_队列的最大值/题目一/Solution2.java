package the59_队列的最大值.题目一;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution2 {
    /**
     * 维护一个大小为size的大顶堆，但是效率太低了
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (size < 1 || size > num.length) {
            return result;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        result.add(heap.peek());

        for (int i = 0, j = size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.add(num[j]);
            result.add(heap.peek());
        }
        return result;
    }
}
