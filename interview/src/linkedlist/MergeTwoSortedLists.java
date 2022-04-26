/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Time Complexity : O(m + n)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class MergeTwoSortedLists {
        
        private LinkedListNode mergeTwoSortedLists(LinkedListNode list1, LinkedListNode list2) {
                // create a dummy variable, point to beginning of result
                LinkedListNode dummy = new LinkedListNode();
                LinkedListNode curr = dummy;
                // iterate till one of the lists is empty
                while (list1 != null && list2 != null) {
                        if (list1.data <= list2.data) {
                                curr.next = list1;
                                list1 = list1.next;
                        } else {
                                curr.next = list2;
                                list2 = list2.next;
                        }
                        curr = curr.next;
                }
                // append the list which still has elements
                curr.next = list1 != null ? list1 : list2;
                return dummy.next;
        }
        
        public static void main(String[] args) {
                LinkedListNode head1 = new LinkedListNode(1);
                head1.next = new LinkedListNode(2);
                head1.next.next = new LinkedListNode(3);
                head1.next.next.next = new LinkedListNode(4);
                LinkedListNode head2 = new LinkedListNode(1);
                head2.next = new LinkedListNode(4);
                head2.next.next = new LinkedListNode(5);
                head1.printLinkedList(new MergeTwoSortedLists().mergeTwoSortedLists(head1, head2));
        }
}
