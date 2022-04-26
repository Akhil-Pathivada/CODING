/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class RemoveDuplicatesFromSortedListII {
        
        private LinkedListNode removeDuplicates(LinkedListNode head) {
                LinkedListNode curr, prev, dummy;
                dummy = new LinkedListNode(0);
                curr = dummy.next = head;
                prev = dummy;
                while (curr != null) {
                        // iterate over all duplicates of current element
                        while (curr.next != null && curr.data == curr.next.data) {
                                curr = curr.next;
                        }
                        if (prev.next == curr) { // duplicate not found for current element
                                prev = prev.next;
                        } else { // duplicate found for current element
                                prev.next = curr.next;
                        }
                        curr = curr.next;
                }
                return dummy.next;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(1);
                head.next.next = new LinkedListNode(2);
                head.next.next.next = new LinkedListNode(3);
                head.next.next.next.next = new LinkedListNode(3);
                head.printLinkedList(new RemoveDuplicatesFromSortedListII().removeDuplicates(head));
        }
}
