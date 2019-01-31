package the9_用两个栈实现队列;

import java.util.*;

/**
 * @author: pinnuli
 * @date: 2019-01-31
 */

public class SimpleStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        if (queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.offer(node);
        } else {
            queue1.offer(node);
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                int temp = queue2.poll();
                queue1.offer(temp);
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                int temp = queue1.poll();
                queue2.offer(temp);
            }
            return queue1.poll();
        }
    }

}
