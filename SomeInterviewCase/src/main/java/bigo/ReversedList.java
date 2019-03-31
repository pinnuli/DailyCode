package bigo;

/**
 * author@ pinnuli
 * date@ 2019/3/31
 */
public class ReversedList {
    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node reverse(Node node) {
        Node reverseNode = null;
        Node currentNode = node;
        Node preNode = null;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                reverseNode = currentNode;
            }
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return reverseNode;
    }
}
