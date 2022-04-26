/**
 * Given a linked list and an integer K, the task is to delete the Kth node from the end of the given linked list.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */

package linkedlist;

public class RemoveKthNodeFromEndOfList {
        
        private LinkedListNode removeKthNodeFromEnd(LinkedListNode head, int K) {
                // create dummy pointer and maintain it before head
                LinkedListNode start = new LinkedListNode(0);
                start.next = head;
                LinkedListNode slow = start, fast = start;
                // move fast in front so that the gap between slow and fast becomes n
                for (int i = 0; i <= K; ++i) {
                        fast = fast.next;
                }
                // move fast to the end, maintaining the gap
                while (fast != null) {
                        slow = slow.next;
                        fast = fast.next;
                }
                // skip the desired node
                slow.next = slow.next.next;
                return start.next;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                int K = 4;
                head.printLinkedList(new RemoveKthNodeFromEndOfList().removeKthNodeFromEnd(head, K));
        }
}
