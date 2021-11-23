package linkedlist;

public class LinkedListNode {
        
        int data; // value of node
        LinkedListNode next; // next pointer
        // default constructor
        public LinkedListNode() {
        
        }
        // initialize a node with value and next pointer
        public LinkedListNode(int value) {
                data = value;
                next = null;
        }
        // Printing Linked List
        public void printLinkedList(LinkedListNode node) {
                while(node != null) {
                        System.out.print(node.data + ", ");
                        node = node.next;
                }
        }
        public int lengthOfLinkedList(LinkedListNode node) {
                int count = 0;
                while(node != null) {
                        ++count;
                        node = node.next;
                }
                return count;
        }
}
