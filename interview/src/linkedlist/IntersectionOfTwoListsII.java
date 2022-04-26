/**
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class IntersectionOfTwoListsII {
        
        private int getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
                LinkedListNode a = headA, b = headB;
                //if a & b have different len, then we will stop the loop after second iteration
                while (a != b) {
                        // for the end of first iteration, we just reset the pointer to the head of another linkedlist
                        a = (a == null) ? headB : a.next;
                        b = (b == null) ? headA : b.next;
                }
                return a.data;
        }
        
        public static void main(String[] args) {
                LinkedListNode headA = new LinkedListNode(10);
                headA.next = new LinkedListNode(20);
                headA.next.next = new LinkedListNode(30);
                headA.next.next.next = new LinkedListNode(40);
                headA.next.next.next.next = new LinkedListNode(50);
                LinkedListNode headB = new LinkedListNode(60);
                headB.next = new LinkedListNode(70);
                headB.next.next = new LinkedListNode(80);
                headB.next.next.next = headA.next.next.next;
                System.out.println(new IntersectionOfTwoListsII().getIntersectionNode(headA, headB));
        }
}
