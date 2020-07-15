package sort.heapsort;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2018-11-26
 */

public class HeapSort2 {
    /**
     * 对整个arr数组使用HeapSort2排序HeapSort2, 借助我们的heapify过程创建堆
     * 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 时间复杂度为O(nlogn)
     * 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for (int i = n - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.heapsort.HeapSort2", arr);
    }
}
