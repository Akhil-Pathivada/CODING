/**
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class IntersectionOfTwoListsI {
        
        private int getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
                int lenA = headA.lengthOfLinkedList(headA);
                int lenB = headB.lengthOfLinkedList(headB);
                // move headA and headB to the same start point
                while (lenA > lenB) {
                        headA = headA.next;
                        --lenA;
                }
                while (lenB > lenA) {
                        headB = headB.next;
                        --lenB;
                }
                // find the intersection until end
                while (headA != headB) {
                        headA = headA.next;
                        headB = headB.next;
                }
                return headA.data;
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
                System.out.println(new IntersectionOfTwoListsI().getIntersectionNode(headA, headB));
        }
}
