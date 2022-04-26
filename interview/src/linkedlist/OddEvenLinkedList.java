/**
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 *
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * */
package linkedlist;

public class OddEvenLinkedList {
        
        private LinkedListNode getOddEvenList(LinkedListNode head) {
                // base case
                if (head == null) {
                        return null;
                }
                LinkedListNode odd = head, even = head.next, evenHead = even;
                // traverse till even pointer reaches to last
                while (even != null && even.next != null) {
                        odd.next = odd.next.next;
                        even.next = even.next.next;
                        odd = odd.next;
                        even = even.next;
                }
                odd.next = evenHead;
                return head;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                head.printLinkedList(new OddEvenLinkedList().getOddEvenList(head));
        }
}
