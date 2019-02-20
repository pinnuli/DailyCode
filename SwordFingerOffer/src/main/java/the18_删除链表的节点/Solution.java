package the18_删除链表的节点;

/**
 * 注意函数返回值应该是ListNode，不应该是void，因为需要考虑头节点的情况
 * 题目一：
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * <p>
 * 题目二：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author: pinnuli
 * @date: 2019-02-20
 */

public class Solution {

    public ListNode deleteNode(ListNode pListHead, ListNode pToBeDeleted) {
        if (pListHead == null || pToBeDeleted == null) {
            return null;
        }

        if (pToBeDeleted.next != null) {
            ListNode pNext = pToBeDeleted.next;
            pToBeDeleted.val = pNext.val;
            pToBeDeleted.next = pNext.next;
        } else if (pListHead == pToBeDeleted) {
            pListHead = null;
        } else {
            ListNode pNode = pListHead;
            while (pNode.next != pToBeDeleted) {
                pNode = pNode.next;
            }
            pNode.next = pToBeDeleted.next;
        }
        return pListHead;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode pNext = pHead.next;
        if (pHead.val == pNext.val) {
            while (pNext != null && pNext.val == pHead.val) {
                pNext = pNext.next;
            }
            return deleteDuplication(pNext);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
