/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class RemoveElementK {
        
        private LinkedListNode removeElement(LinkedListNode head, int k) {
                // base case
                if(head == null) {
                        return head;
                }
                LinkedListNode curr = new LinkedListNode(0);
                LinkedListNode dummy = curr;
                curr.next = head;
                while (curr.next != null) {
                        if (curr.next.data == k) {
                                curr.next = curr.next.next;
                        } else {
                                curr = curr.next;
                        }
                }
                return dummy.next;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(6);
                head.next.next.next = new LinkedListNode(3);
                head.next.next.next.next = new LinkedListNode(4);
                head.next.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next.next = new LinkedListNode(6);
                int k = 6;
                head = new RemoveElementK().removeElement(head, k);
                head.printLinkedList(head);
        }
}
