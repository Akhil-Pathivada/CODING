/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class RemoveDuplicatesFromSortedListI {
        
        private LinkedListNode removeDuplicates(LinkedListNode head) {
                LinkedListNode curr = head;
                while (curr != null) {
                        if (curr.next != null && curr.data == curr.next.data) {
                                curr.next = curr.next.next;
                        } else {
                                curr = curr.next;
                        }
                }
                return head;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(1);
                head.next.next = new LinkedListNode(2);
                head.next.next.next = new LinkedListNode(3);
                head.next.next.next.next = new LinkedListNode(3);
                head.printLinkedList(new RemoveDuplicatesFromSortedListI().removeDuplicates(head));
        }
}
