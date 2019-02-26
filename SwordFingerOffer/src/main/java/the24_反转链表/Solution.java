package the24_反转链表;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author: pinnuli
 * @date: 2019-02-24
 */

public class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode pReversedHead = null;
        ListNode pNode = head;
        ListNode pPre = null;

        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }

            pNode.next = pPre;

            pPre = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }
}
