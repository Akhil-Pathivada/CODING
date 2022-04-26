/**
 * Program to find the middle node of the Linked List without using 'Count' variable
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */

package linkedlist;

public class MiddleNodeOfList {
        
        private int getMiddleNodeOfList(LinkedListNode head) {
                LinkedListNode slow, fast;
                slow = fast = head;
                while (fast != null && fast.next != null) {
                        slow = slow.next;
                        fast = fast.next.next;
                }
                return slow.data;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(3);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(4);
                head.next.next.next = new LinkedListNode(2);
                head.next.next.next.next = new LinkedListNode(7);
                head.next.next.next.next.next = new LinkedListNode(5);
                System.out.println(new MiddleNodeOfList().getMiddleNodeOfList(head));
        }
}
