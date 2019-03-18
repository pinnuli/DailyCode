package the36_二叉树与双向链表;

/**
 * author@ pinnuli
 * date@ 2019/3/9
 */
public class Solution {
    TreeNode pHeadOfList = null;
    TreeNode pLastOfList = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        return pHeadOfList;
    }

    private void convertNode(TreeNode pNode) {
        if (pNode == null) {
            return;
        }

        TreeNode pCurrent = pNode;

        if (pCurrent.left != null) {
            convertNode(pCurrent.left);
        }

        pCurrent.left = pLastOfList;
        if (pLastOfList != null) {
            pLastOfList.right = pCurrent;
        }

        if (pHeadOfList == null) {
            pHeadOfList = pCurrent;
        }

        pLastOfList = pCurrent;
        if(pCurrent.right != null) {
            convertNode(pCurrent.right);
        }
    }
}
