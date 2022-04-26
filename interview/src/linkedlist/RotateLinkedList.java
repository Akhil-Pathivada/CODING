/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * https://leetcode.com/problems/rotate-list/
 *
 * Time Complexity : O(min(N, K))
 * Space Complexity : O(1)
 * */
package linkedlist;

public class RotateLinkedList {
        
        private LinkedListNode rotateRight(LinkedListNode head, int k) {
                // base case
                if (head == null) {
                        return null;
                }
                int length  = 1;
                LinkedListNode tail = head;
                // get the tail pointer
                while (tail.next != null) {
                        ++length;
                        tail = tail.next;
                }
                // even if k > length, calculate how many rotations needed exactly
                k %= length;
                // if k == 0 or k == length of list
                if (k == 0) {
                        return head;
                }
                LinkedListNode current = head;
                // traverse till the node before the new head
                for (int i = 0; i < length - k - 1; ++i) {
                        current = current.next;
                }
                // point the new head
                LinkedListNode newHead = current.next;
                // make current as last
                current.next = null;
                // point the tail next to old head
                tail.next = head;
                return newHead;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                // no. of rotations
                int k = 10;
                head.printLinkedList(new RotateLinkedList().rotateRight(head, k));
        }
}
