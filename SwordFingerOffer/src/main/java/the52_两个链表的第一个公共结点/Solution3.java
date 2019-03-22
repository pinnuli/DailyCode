package the52_两个链表的第一个公共结点;

/**
 * @author: pinnuli
 * @date: 2019-03-22
 */

public class Solution3 {
    /**
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，
     * 可知 a + c + b = b + c + a。
     * 当访问链表 A 的指针访问到链表尾部时，
     * 令它从链表 B 的头部重新开始访问链表 B；
     * 同样地，当访问链表 B 的指针访问到链表尾部时，
     * 令它从链表 A 的头部重新开始访问链表 A。
     * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode pNode1 = pHead1, pNode2 = pHead2;
        while (pNode1 != pNode2) {
            pNode1 = (pNode1 == null) ? pHead2 : pNode1.next;
            pNode2 = (pNode2 == null) ? pHead1 : pNode2.next;
        }
        return pNode1;
    }
}
