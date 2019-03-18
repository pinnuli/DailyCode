package the41_数据流中的中位数;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 这里是用java的优先队列解决
 * <p>
 * date@ 2019/3/16
 *
 * @author pinnuli
 */
public class Solution2 {

    PriorityQueue<Integer> maxLeftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    PriorityQueue<Integer> minRightHeap = new PriorityQueue<>();

    int totalCount = 0;

    public void insert(Integer num) {
        if ((totalCount & 1) == 0) {
            minRightHeap.add(num);
            maxLeftHeap.add(minRightHeap.poll());
        } else {
            maxLeftHeap.add(num);
            minRightHeap.add(maxLeftHeap.poll());
        }
        totalCount++;
    }

    public Double GetMedian() {
        if ((totalCount & 1) == 0) {
            return (maxLeftHeap.peek() + minRightHeap.peek()) / 2.0;
        }
        return (double) maxLeftHeap.peek();
    }


}
