package the52_两个链表的第一个公共结点;

/**
 * @author: pinnuli
 * @date: 2019-03-22
 */

public class Solution2 {
    /**
     * 先计算链表的长度，然后遍历链表，较长的链表先走len2-len1步
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while (pNode1 != null) {
            len1 ++;
            pNode1 = pNode1.next;
        }
        while (pNode2 != null) {
            len2 ++;
            pNode2 = pNode2.next;
        }
        pNode1 = pHead1;
        pNode2 = pHead2;
        if (len1 < len2) {
            while (len1 < len2) {
                pNode2 = pNode2.next;
                len1 ++;
            }
        } else {
            while (len2 < len1) {
                pNode1 = pNode1.next;
                len2 ++;
            }
        }
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}
