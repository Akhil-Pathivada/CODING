/**
 * Check whether a Linked List is PALINDROME or not
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class CheckPalindromeII {
        
        private LinkedListNode reverseList(LinkedListNode head) {
                LinkedListNode prev, curr, nextPtr;
                prev = null;
                curr = head;
                while (curr != null) {
                        nextPtr = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = nextPtr;
                }
                return prev;
        }
        
        private boolean isPalindrome(LinkedListNode head) {
                LinkedListNode slow, fast;
                slow = fast = head;
                // get middle of list
                while (fast != null && fast.next != null) {
                        slow = slow.next;
                        fast = fast.next.next;
                }
                // odd nodes: let right half smaller
                if (fast != null) {
                        slow = slow.next;
                }
                slow = reverseList(slow);
                fast = head;
                // slow pointer will reach to end first
                while (slow != null) {
                        if (slow.data != fast.data) {
                                return false;
                        }
                        slow = slow.next;
                        fast = fast.next;
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
                System.out.println(new CheckPalindromeII().isPalindrome(head));
        }
}
