package the6_从尾到头打印链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: pinnuli
 * @date: 2018-12-08
 */

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack nodeStack = new Stack<ListNode>();
        ArrayList nodeList = new ArrayList<ListNode>();
        ListNode pNode = listNode;
        while(pNode != null) {
            nodeStack.push(pNode);
            pNode = pNode.next;
        }
        while(!nodeStack.empty()) {
            pNode = (ListNode)nodeStack.pop();
            nodeList.add(pNode.val);
        }
        return nodeList;
    }
}
