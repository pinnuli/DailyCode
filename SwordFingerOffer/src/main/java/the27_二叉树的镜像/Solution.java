package the27_二叉树的镜像;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的镜像定义：源二叉树
 *      8
 *    /  \
 *   6   10
 *  / \  / \
 * 5  7 9  11
 * 镜像二叉树
 *     8
 *   /  \
 *  10   6
 * / \  / \
 * 11 9 7  5
 * @author: pinnuli
 * @date: 2019-02-27
 */

public class Solution {

    /**
     * 递归遍历
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    /**
     * 层次遍历，根节点不为 null 将根节点入队，判断队不为空时，节点出队，
     * 交换该节点的左右孩子，如果左右孩子不为空，将左右孩子入队。
     * @param root
     */
    public void mirrorWithQueue(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swap(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 先序遍历，如果根节点不为 null 将根节点入栈，
     * 当栈不为 null 出栈，交换左右节点，
     * 如果左右节点不为 null 入栈。
     * @param root
     */
    public void mirrorWithStack(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
