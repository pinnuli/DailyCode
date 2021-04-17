package com.pinnuli.leetcode.num199_二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linxiaoyi
 * @date 2021/4/17
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList();
        LinkedList<TreeNode> queue2 = new LinkedList();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.poll();
                    if (queue1.size() == 0) {
                        result.add(node.val);
                    }
                    if (node.left != null) {
                        queue2.offer(node.left);
                    }
                    if (node.right != null) {
                        queue2.offer(node.right);
                    }
                }
            }
            if (!queue2.isEmpty()) {
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.poll();
                    if (queue2.size() == 0) {
                        result.add(node.val);
                    }
                    if (node.left != null) {
                        queue1.offer(node.left);
                    }
                    if (node.right != null) {
                        queue1.offer(node.right);
                    }
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == currentSize - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
}
