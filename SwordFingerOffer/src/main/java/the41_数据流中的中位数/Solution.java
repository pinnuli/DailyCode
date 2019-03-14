package the41_数据流中的中位数;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * author@ pinnuli
 * date@ 2019/3/14
 */
public class Solution {
    List<Integer> leftMaxHeap = new ArrayList<>();

    List<Integer> rightMinHeap = new ArrayList<>();

    int totalCount = 0;

    public void Insert(Integer num) {
        if ((totalCount & 1) == 0) {
            if (rightMinHeap.size() > 0 && num > rightMinHeap.get(0)) {
                leftMaxHeap.add(rightMinHeap.get(0));
                rightMinHeap.set(0, num);
                minHeapAdjust(rightMinHeap, 0, rightMinHeap.size() - 1);
            } else {
                leftMaxHeap.add(num);
            }
            maxHeapAdjust(leftMaxHeap, 0, leftMaxHeap.size() - 1);
        } else {
            if (leftMaxHeap.size() > 0 && num < leftMaxHeap.get(0)) {
                rightMinHeap.add(leftMaxHeap.get(0));
                leftMaxHeap.set(0, num);
                maxHeapAdjust(leftMaxHeap, 0, leftMaxHeap.size() - 1);
            } else {
                rightMinHeap.add(num);
            }
            minHeapAdjust(rightMinHeap, 0, leftMaxHeap.size() - 1);
        }

        totalCount ++;
    }

    public Double GetMedian() {
        if ((totalCount & 1) == 0) {
            return (leftMaxHeap.get(0) + rightMinHeap.get(0)) / 2.0;
        }
        return (double)leftMaxHeap.get(0);
    }

    private void minHeapAdjust(List<Integer> heap, int start, int end) {
        int temp = heap.get(start);
        for (int j = 2 * start + 1; j <= end; j *= 2) {
            if (j < end && heap.get(j) > heap.get(j + 1)) {
                j++;
            }
            if (heap.get(start) <= heap.get(j)) {
                break;
            }

            heap.set(start, heap.get(j));
            start = j;
        }
        heap.set(start, temp);
    }

    private void maxHeapAdjust(List<Integer> heap, int start, int end) {
        int temp = heap.get(start);
        for (int j = 2 * start + 1; j <= end; j *= 2) {
            if (j < end && heap.get(j) < heap.get(j + 1)) {
                j++;
            }
            if (heap.get(start) >= heap.get(j)) {
                break;
            }

            heap.set(start, heap.get(j));
            start = j;
        }
        heap.set(start, temp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{5,2,3,4,1,6,7};
        for (int i = 0; i < array.length; i++) {
            solution.Insert(array[i]);
        }
        System.out.println(solution.GetMedian());
    }
}
