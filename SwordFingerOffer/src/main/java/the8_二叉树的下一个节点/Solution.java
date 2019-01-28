package the8_二叉树的下一个节点;

/**
 * @author: pinnuli
 * @date: 2019-01-28
 */

public class Solution {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        TreeLinkNode pNext = null;
        if(pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while(pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        }

        if(pNode.next != null) {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while(pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }
}
