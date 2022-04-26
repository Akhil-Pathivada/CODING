/**
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 *
 * Time Complexity : O(N)
 * Space Comnplexity : O(N/K) -> For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.
 * */
package linkedlist;

public class ReverseLinkedListInGroupsOfSizeKI {
        
        private LinkedListNode reverseKNodes(LinkedListNode head, int k) {
                // base case
                if (head == null) {
                        return null;
                }
                LinkedListNode current = head;
                LinkedListNode prev = null, next = null;
                // Reverse first k nodes of linked list
                for (int count = 1; count <= k && current != null; ++count) {
                        next = current.next;
                        current.next = prev;
                        prev = current;
                        current = next;
                }
                /** next is now a pointer to (k+1)th node
                Recursively call for the list starting from
                current. And make rest of the list as next of
                first node */
                if (next != null) {
                        head.next = reverseKNodes(next, k);
                }
                // prev is now head of input list
                return prev;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                head.next.next.next.next.next.next = new LinkedListNode(7);
                head.next.next.next.next.next.next.next = new LinkedListNode(8);
                head.next.next.next.next.next.next.next.next = new LinkedListNode(9);
                int k = 3;
                head.printLinkedList(new ReverseLinkedListInGroupsOfSizeKI().reverseKNodes(head, 3));
        }
}
