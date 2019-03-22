package the52_两个链表的第一个公共结点;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author: pinnuli
 * @date: 2019-03-22
 */

public class Solution1 {
    /**
     * 使用两个栈来保存结点，然后从栈顶开始比较
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while (pNode1 != null) {
            stack1.push(pNode1);
            pNode1 = pNode1.next;
        }
        while (pNode2 != null) {
            stack2.push(pNode2);
            pNode2 = pNode2.next;
        }
        ListNode pResult = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            pNode1 = stack1.pop();
            pNode2 = stack2.pop();
            if (pNode1 != pNode2) {
                break;
            }
            pResult = pNode1;
        }
        return pResult;
    }

}
