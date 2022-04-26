/**
 * Program to split the Alternative nodes in the Linked List
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class AlternateSplitList {
        
        private void alternateSplitList(LinkedListNode head) {
                LinkedListNode head1, head2;
                head1 = head;
                head2 = head.next;
                while (head != null) {
                        LinkedListNode temp = head.next;
                        head.next = temp != null ? temp.next : temp;
                        head = temp;
                }
                head1.printLinkedList(head1);
                head2.printLinkedList(head2);
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                new AlternateSplitList().alternateSplitList(head);
        }
}
