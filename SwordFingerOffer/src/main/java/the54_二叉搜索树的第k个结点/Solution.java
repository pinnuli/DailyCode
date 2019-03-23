package the54_二叉搜索树的第k个结点;

/**
 * author@ pinnuli
 * date@ 2019/3/23
 */
public class Solution {
    private TreeNode result = null;
    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot, k);
        return result;

    }

    private void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null || index >= k) {
            return;
        }
        inOrder(pRoot.left, k);
        index ++;
        if (index == k) {
            result = pRoot;
        }
        inOrder(pRoot.right, k);
    }
}
