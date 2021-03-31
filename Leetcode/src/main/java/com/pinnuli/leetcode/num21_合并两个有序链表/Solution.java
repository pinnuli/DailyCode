package com.pinnuli.leetcode.num21_合并两个有序链表;

/**
 * @author linxiaoyi
 * @date 2021/3/31
 */
public class Solution {

    // 时间复杂度 o(n + m)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode currentNode = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    // 时间复杂度：O(n + m), 空间复杂度：O(n + m)
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
