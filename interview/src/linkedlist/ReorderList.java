/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/reorder-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class ReorderList {
        // reverse the second half
        private LinkedListNode reverse(LinkedListNode head) {
                LinkedListNode curr = head, prev = null;
                while (curr != null) {
                        LinkedListNode next = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = next;
                }
                return prev;
        }
        // get the middle node of list
        private LinkedListNode middle(LinkedListNode head) {
                LinkedListNode slow = head, fast = head;
                while (fast != null && fast.next != null) {
                        slow = slow.next;
                        fast = fast.next.next;
                }
                return slow;
        }
        
        private void reorderList(LinkedListNode head) {
                if (head == null) {
                        return;
                }
                LinkedListNode curr1 = head;
                LinkedListNode curr2 = reverse(middle(head));
                // merge two lists alternatively
                while (curr1 != null && curr2 != null) {
                        // last node of list1 still points to node in list2, so remove it
                        if (curr1.next == curr2) {
                                curr1.next = null;
                        }
                        LinkedListNode temp1 = curr1.next;
                        LinkedListNode temp2 = curr2.next;
                        curr1.next = curr2;
                        curr2.next = temp1;
                        curr1 = temp1;
                        curr2 = temp2;
                }
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next =  new LinkedListNode(2);
                head.next.next =  new LinkedListNode(3);
                head.next.next.next =  new LinkedListNode(4);
                head.next.next.next.next =  new LinkedListNode(5);
                new ReorderList().reorderList(head);
                head.printLinkedList(head);
        }
}
