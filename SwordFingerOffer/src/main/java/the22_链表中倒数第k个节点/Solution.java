package the22_链表中倒数第k个节点;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author: pinnuli
 * @date: 2019-02-24
 */

public class Solution {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode preNode = head;
        ListNode postNode = head;
        for (int i = 0; i < k - 1; i ++ ) {
            if (preNode.next != null) {
                preNode = preNode.next;
            } else {
                return null;
            }
        }

        while (preNode.next != null) {
            preNode = preNode.next;
            postNode = postNode.next;
        }

        return postNode;
    }
}
