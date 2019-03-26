package the59_队列的最大值.题目二;

import java.util.ArrayDeque;

/**
 * author@ pinnuli
 * date@ 2019/3/26
 */
public class Solution {
    private ArrayDeque<Integer> dataQueue = new ArrayDeque<>();
    private ArrayDeque<Integer> maxQueue = new ArrayDeque<>();

    public void push(int number) {
        dataQueue.add(number);
        if (maxQueue.isEmpty()) {
            maxQueue.add(number);
        } else {
            maxQueue.add(number > maxQueue.peek() ? number : maxQueue.peek());
        }
    }

    public int pop() {
        if (dataQueue.isEmpty()) {
            throw  new RuntimeException("Queue is empty");
        }
        maxQueue.poll();
        return dataQueue.poll();
    }

    public int max() {
        if (dataQueue.isEmpty()) {
            throw  new RuntimeException("Queue is empty");
        }
        return maxQueue.peek();
    }
}
