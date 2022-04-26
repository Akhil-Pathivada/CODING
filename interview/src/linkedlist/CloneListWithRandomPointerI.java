/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneListWithRandomPointerI {
        
        static class LinkedListNode {
                int data;
                LinkedListNode next, random;
                // initialize a node with value and next, random pointer
                LinkedListNode(int value) {
                        data = value;
                        next = random = null;
                }
                private void printList(LinkedListNode head) {
                        for ( ; head != null; head = head.next) {
                                System.out.println(head.data + ", " + head.random.data);
                        }
                }
        }
        
        private static LinkedListNode cloneList(LinkedListNode head) {
                // maintain two pointers, one of them should point to original list
                LinkedListNode originalCurr, clonedCurr;
                originalCurr = head;
                // store <old, new> address of a node in hashmap
                Map<LinkedListNode, LinkedListNode> hashMap = new HashMap<>();
                // insert entries into map
                while (originalCurr != null) {
                        clonedCurr = new LinkedListNode(originalCurr.data);
                        hashMap.put(originalCurr, clonedCurr);
                        originalCurr = originalCurr.next;
                }
                originalCurr = head;
                // copy contents of old node's into new node
                while (originalCurr != null) {
                        clonedCurr = hashMap.get(originalCurr);
                        clonedCurr.next = hashMap.get(originalCurr.next);
                        clonedCurr.random = hashMap.get(originalCurr.random);
                        originalCurr = originalCurr.next;
                }
                return hashMap.get(head);
        }
        
        public static void main(String[] args) {
                CloneListWithRandomPointerI obj = new CloneListWithRandomPointerI();
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                // initialize random pointers
                head.random = head.next.next;
                head.next.random = head.next.next.next;
                head.next.next.random = head.next.next.next.next;
                head.next.next.next.random = head;
                head.next.next.next.next.random = head.next;
                // get cloned list
                LinkedListNode clonedListHead = cloneList(head);
                clonedListHead.printList(clonedListHead);
        }
}
