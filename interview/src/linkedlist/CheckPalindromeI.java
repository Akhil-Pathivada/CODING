/**
 * Check whether a Linked List is PALINDROME or not
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package linkedlist;

import java.util.Stack;

public class CheckPalindromeI {
        
        private boolean isPalindrome(LinkedListNode head) {
                LinkedListNode curr = head;
                Stack<Integer> stack = new Stack<>();
                // push all elements into stack
                while (curr != null) {
                        stack.push(curr.data);
                        curr = curr.next;
                }
                // if it is palindrome, always the poppped element is equal to current element
                for (curr = head; curr != null; curr = curr.next) {
                        if(stack.pop() != curr.data) {
                                return false;
                        }
                }
                return true;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(3);
                head.next.next.next.next = new LinkedListNode(2);
                head.next.next.next.next.next = new LinkedListNode(1);
                System.out.println(new CheckPalindromeI().isPalindrome(head));
        }
}
