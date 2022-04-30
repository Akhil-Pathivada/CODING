/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/reorder-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package linkedlist;

import java.util.Stack;

public class ReorderList {
        
        private void reorderList(LinkedListNode head) {
                if (head == null) {
                        return;
                }
                Stack<LinkedListNode> stack = new Stack<>();
                LinkedListNode current = head;
                while (current != null) {
                        stack.push(current);
                }
                current = head;
                LinkedListNode temp, node;
                while (true) {
                        node = stack.pop();
                        if (node == current) {
                                break;
                        }
                        temp = current.next;
                        current.next = node;
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
