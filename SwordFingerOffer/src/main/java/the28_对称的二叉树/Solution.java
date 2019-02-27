package the28_对称的二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: pinnuli
 * @date: 2019-02-27
 */

public class Solution {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.val != tree2.val) {
            return false;
        }

        return isSymmetrical(tree1.left, tree2.right)
                && isSymmetrical(tree1.right, tree2.left);
    }

    /**
     * 非递归实现
     * @param pRoot
     * @return
     */
    public boolean isSymmetricalWithStack(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        stack2.add(pRoot);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            if (!(node1.left == null && node1.right == null)) {
                stack1.push(node1.left);
                stack1.push(node1.right);
            }
            if (!(node2.left == null && node2.right == null)) {
                stack2.push(node2.right);
                stack2.push(node2.left);
            }
        }
        return true;
    }
}
