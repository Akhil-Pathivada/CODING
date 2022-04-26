/**
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 *
 * Time Complexity : O(N)
 * Space Comnplexity : O(K)
 * */
package linkedlist;

import java.util.Stack;

public class ReverseLinkedListInGroupsOfSizeKII {
        
        private LinkedListNode reverseKNodes(LinkedListNode head, int k) {
                // base case
                if (head == null) {
                        return null;
                }
                Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
                LinkedListNode current = head, prev = null;
                while (current != null) {
                        // Terminate the loop whichever comes first either current == NULL or count >= k
                        for (int count = 1; count <= k && current != null; ++count) {
                                stack.push(current);
                                current = current.next;
                        }
                        // Now pop the elements of stack one by one
                        while (!stack.isEmpty()) {
                                LinkedListNode temp = stack.pop();
                                // If result list has not been started yet.
                                if (prev == null) {
                                        prev = temp;
                                        head = prev;
                                } else {
                                        prev.next = temp;
                                        prev = temp;
                                }
                        }
                }
                // Next of last element will point to NULL.
                prev.next = null;
                return head;
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
                head.printLinkedList(new ReverseLinkedListInGroupsOfSizeKII().reverseKNodes(head, 3));
        }
}
