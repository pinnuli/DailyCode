package com.pinnuli.leetcode.num19_删除链表的倒数第n个结点;

import java.util.List;
import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author linxiaoyi
 * @date 2021/3/29
 */
public class Solution {


    public static ListNode removeNthFromEndByStack(ListNode head, int n) {
        Stack nodeStack = new Stack<ListNode>();
        ListNode node = head;
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }
        for (int i = n; i > 0; i--) {
            node = (ListNode) nodeStack.pop();
        }
        if (nodeStack.isEmpty()) {
            head = node.next;
        } else {
            ListNode preNode = (ListNode) nodeStack.pop();
            preNode.next = node.next;
        }
        return head;
    }

    public static ListNode removeNthFromEndByLength(ListNode head, int n) {
        int listLength = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            listLength ++;
            currentNode = currentNode.next;
        }
        int deleteIndex = listLength - n + 1;
        ListNode preNode = new ListNode(0, head);
        currentNode = preNode;
        for (int i = 1; i < deleteIndex; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return preNode.next;

    }

    public static ListNode removeNthFromEndByDoublePointer(ListNode head, int n) {
        ListNode preHead = new ListNode(0, head);
        ListNode first = preHead;
        ListNode second = preHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return preHead.next;
    }

    public static void main(String[] args) {

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
