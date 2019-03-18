package the40_最小的k个数;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * author@ pinnuli
 * date@ 2019/3/17
 */
public class Solution2 {
    /**
     * 使用大小为k的大顶堆，堆满之后每个数字与堆顶比较，小于堆顶的插入堆，并将堆顶排出
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getleastnumbersSolution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();

        if (input.length < k || k <= 0 ) {
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : input) {
            if (maxHeap.size() < k) {
                maxHeap.add(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.add(num);
                    maxHeap.poll();
                }
            }
        }

        for (int num : maxHeap) {
            result.add(num);
        }
        return result;
    }
}
