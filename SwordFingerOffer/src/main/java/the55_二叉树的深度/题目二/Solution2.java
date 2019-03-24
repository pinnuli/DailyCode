package the55_二叉树的深度.题目二;

/**
 * author@ pinnuli
 * date@ 2019/3/24
 */
public class Solution2 {

    private boolean isBalanced = true;

    /**
     * 使用后序遍历，边遍历节点边判断
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
}
