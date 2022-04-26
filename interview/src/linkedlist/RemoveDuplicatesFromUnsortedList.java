/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedList {
        
        private LinkedListNode removeDuplicates(LinkedListNode head) {
                LinkedListNode prev, curr;
                prev = curr = head;
                // Hash to store seen values
                HashSet<Integer> hashSet = new HashSet<>();
                while (curr != null) {
                        // If current value is seen before
                        if (hashSet.contains(curr.data)) {
                                prev.next = curr.next;
                        } else {
                                hashSet.add(curr.data);
                                prev = curr;
                        }
                        curr = curr.next;
                }
                return head;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(10);
                head.next = new LinkedListNode(12);
                head.next.next = new LinkedListNode(11);
                head.next.next.next = new LinkedListNode(11);
                head.next.next.next.next = new LinkedListNode(12);
                head.next.next.next.next.next = new LinkedListNode(11);
                head.next.next.next.next.next.next = new LinkedListNode(10);
                head.printLinkedList(new RemoveDuplicatesFromUnsortedList().removeDuplicates(head));
        }
}
