package com.pinnuli.leetcode.num98_验证二叉搜索树;

import java.util.Stack;

/**
 * @author linxiaoyi
 * @date 2021/4/21
 */
public class Solution {

    public boolean isValidBSTRecursion(TreeNode root) {
        return isValidBSTCore(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorder = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    private boolean isValidBSTCore(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBSTCore(node.left, min, node.val) && isValidBSTCore(node.right, node.val, max);
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

}
