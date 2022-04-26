/**
 *
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInList {
        
        private int[] nextGreaterNodes(LinkedListNode head) {
                List<Integer> A = new ArrayList<>();
                // store elements into list
                for (LinkedListNode curr = head; curr != null; curr = curr.next) {
                        A.add(curr.data);
                }
                int result[] = new int[A.size()];
                Stack<Integer> stack = new Stack<>();
                // traverse list from start
                for (int i = 0; i < A.size(); ++i) {
                        // when a greater node occurs pop elements from stack: current node becomes Greater node for the popped elements
                        while (!stack.isEmpty() && A.get(i) > A.get(stack.peek())) {
                                result[stack.pop()] = A.get(i);
                        }
                        // push the index instead of node
                        stack.push(i);
                }
                return result;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(3);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(4);
                head.next.next.next = new LinkedListNode(2);
                head.next.next.next.next = new LinkedListNode(7);
                head.next.next.next.next.next = new LinkedListNode(5);
                System.out.println(Arrays.toString(new NextGreaterNodeInList().nextGreaterNodes(head)));
        }
}
