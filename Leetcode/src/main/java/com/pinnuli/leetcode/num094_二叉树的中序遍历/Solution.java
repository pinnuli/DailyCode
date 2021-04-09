package com.pinnuli.leetcode.num094_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author linxiaoyi
 * @date 2021/4/9
 */
public class Solution {

    /**
     * 递归实现,时间复杂度O(n)，空间复杂度O(n)
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversalCore(result, root);
        return result;
    }

    private void inorderTraversalCore(List<Integer> result, TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            inorderTraversalCore(result, node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            inorderTraversalCore(result, node.right);
        }
    }

    /**
     * 迭代实现,时间复杂度O(n)，空间复杂度O(n)
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static List<Integer> inorderTraversalMirrors(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
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
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = inorderTraversal(root);
    }
}


