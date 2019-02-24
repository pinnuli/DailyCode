package the22_链表中环的入口节点;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author: pinnuli
 * @date: 2019-02-24
 */

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        int nodeInLoop = 1;
        ListNode preNode = meetingNode.next;
        while (preNode != meetingNode) {
            nodeInLoop ++;
            preNode = preNode.next;
        }

        preNode = pHead;
        for (int i = 0; i < nodeInLoop; i ++) {
            preNode = preNode.next;
        }

        ListNode postNode = pHead;
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next;
        }
        return preNode;
    }

    public ListNode meetingNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode pSlow = pHead;
        ListNode pFast = pSlow.next;

        while (pFast != null && pSlow != null) {
            if (pFast == pSlow) {
                return pFast;
            }

            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) {
                pFast = pFast.next;
            }
        }
        return null;
    }
}
