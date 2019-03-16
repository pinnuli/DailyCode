
package the8_二叉树的下一个节点;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 28, 2019</pre>
 */
public class SolutionTest {

    /**
     * Method: getNext(TreeLinkNode pNode)
     */
    @Test
    public void testGetNext() throws Exception {
        TreeLinkNode pNode = null;
        TreeLinkNode pLeft = null;
        TreeLinkNode pRight = null;

        pNode = new TreeLinkNode(1);
        pLeft = new TreeLinkNode(2);
        pRight = new TreeLinkNode(3);
        buildTreeNode(pNode, pLeft, pRight);

        pNode = pLeft;
        pLeft = new TreeLinkNode(4);
        pRight = new TreeLinkNode(5);
        buildTreeNode(pNode, pLeft, pRight);

        pNode = pNode.next.right;
        pLeft = new TreeLinkNode(6);
        pRight = new TreeLinkNode(7);
        buildTreeNode(pNode, pLeft, pRight);

        pNode = pNode.next.left.right;
        pLeft = new TreeLinkNode(8);
        pRight = new TreeLinkNode(9);
        buildTreeNode(pNode, pLeft, pRight);

        Solution solution = new Solution();
        System.out.println(solution.getNext(pLeft).val);
    }

    public void buildTreeNode(TreeLinkNode pNode,
                              TreeLinkNode pLeft,
                              TreeLinkNode pRight) {
        pNode.left = pLeft;
        pLeft.next = pNode;
        pNode.right = pRight;
        pRight.next = pNode;
    }
} 
