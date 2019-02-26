package the25_合并两个排序的链表;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author: pinnuli
 * @date: 2019-02-25
 */

public class Solution {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode mergeListHead;
        if (list1.val < list2.val) {
            mergeListHead = list1;
            mergeListHead.next = Merge(list1.next, list2);
        } else {
            mergeListHead = list2;
            mergeListHead.next = Merge(list1, list2.next);
        }

        return mergeListHead;
    }
}
