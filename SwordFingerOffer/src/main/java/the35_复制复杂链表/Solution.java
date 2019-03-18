package the35_复制复杂链表;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * author@ pinnuli
 * date@ 2019/3/9
 */
public class Solution {

    public RandomListNode Clone(RandomListNode pHead)
    {
        cloneNode(pHead);
        cloneComplexNode(pHead);
        return reConnectNodes(pHead);
    }

    private void cloneNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pClone = new RandomListNode(pNode.label);
            pClone.next = pNode.next;
            pNode.next = pClone;
            pNode = pClone.next;
        }
    }

    private void cloneComplexNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClone;
        while (pNode != null) {
            pClone = pNode.next;
            if (pNode.random != null) {
                pClone.random = pNode.random.next;
            }
            pNode = pClone.next;
        }
    }

    private RandomListNode reConnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pCloneNode = null;
        RandomListNode pCloneHead = null;

        if (pHead != null) {
            pCloneHead = pNode.next;
            pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return pCloneHead;
    }
}
