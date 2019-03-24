package the55_二叉树的深度.题目二;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * author@ pinnuli
 * date@ 2019/3/24
 */
public class Solution1 {
    /**
     * 直接从根节点开始判断，但是会重复遍历子节点，效率低
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left > right) ? left + 1 : right + 1;
    }
}
