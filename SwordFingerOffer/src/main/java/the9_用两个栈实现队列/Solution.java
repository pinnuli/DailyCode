package the9_用两个栈实现队列;

import java.util.Stack;

/**
 * @author: pinnuli
 * @date: 2019-01-31
 */

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return stack2.pop();
    }
}
