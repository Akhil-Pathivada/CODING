/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class KthNodeFromEndOfList {
        
        private int findNode(LinkedListNode head, int k) {
                // base case
                if (head == null || k <= 0) {
                        return -1;
                }
                LinkedListNode slow = head, fast = head;
                // keep fast pointer at Kth position from start
                for (int i = 1; i < k && fast != null; ++i) {
                        fast = fast.next;
                }
                // K > N
                if (fast == null) {
                        return -1;
                }
                // iterate till fast reaches end
                while (fast.next != null) {
                        slow = slow.next;
                        fast = fast.next;
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
                int k = 5;
                System.out.printf("%d th node from the end = %d ", k, new KthNodeFromEndOfList().findNode(head, k));
        }
}
