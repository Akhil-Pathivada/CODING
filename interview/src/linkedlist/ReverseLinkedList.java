
package linkedlist;

public class ReverseLinkedList {
        
        private LinkedListNode reverseList(LinkedListNode head) {
                LinkedListNode prev, curr, nextPtr;
                prev = null;
                curr = head;
                while (curr != null) {
                        nextPtr = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = nextPtr;
                }
                return prev;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(3);
                head.next = new LinkedListNode(1);
                head.next.next = new LinkedListNode(4);
                head.next.next.next = new LinkedListNode(2);
                head.next.next.next.next = new LinkedListNode(7);
                head.next.next.next.next.next = new LinkedListNode(5);
                head.printLinkedList(new ReverseLinkedList().reverseList(head));
        }
}
