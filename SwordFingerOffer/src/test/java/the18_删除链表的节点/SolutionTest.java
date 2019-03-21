
package the18_删除链表的节点;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.LinkedList;

/**
 * Solution1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 20, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: deleteNode(ListNode pListHead, ListNode pToBeDeleted)
     */
    @Test
    public void testDeleteNode() throws Exception {
        ListNode pHead = null;
        ListNode pPre = null;
        for (int i = 1; i <= 1; i++) {
            ListNode pNode = new ListNode(i);
            if (i == 1) {
                pHead = pNode;
                pPre = pHead;
            }
            pPre.next = pNode;
            pPre = pNode;
        }

        Solution solution = new Solution();
        ListNode pToBeDelete = pHead;
        pPre = pHead;
        for (int i = 1; i <= 1; i++) {
            pToBeDelete = pPre;
            pPre = pPre.next;
        }
        System.out.println("删除之前pHead：" + pHead.val);
        System.out.println("删除之前pToBeDelete：" + pToBeDelete.val);
        pHead = solution.deleteNode(pHead, pToBeDelete);
        System.out.println("删除之后pHead：" + pHead.val);
        System.out.println("删除之后pToBeDelete：" + pToBeDelete.val);
    }
} 
