/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class CloneListWithRandomPointerII {
        
        static class LinkedListNode {
                int data;
                LinkedListNode next, random;
                // initialize a node with value and next, random pointer
                LinkedListNode(int value) {
                        data = value;
                        next = random = null;
                }
                private void printList(LinkedListNode head) {
                        for( ; head != null; head = head.next) {
                                System.out.println(head.data + ", " + head.random.data);
                        }
                }
        }
        
        private static LinkedListNode alternateSplitList(LinkedListNode head) {
                LinkedListNode clonedListHead = head.next;
                while (head != null) {
                        LinkedListNode temp = head.next;
                        head.next = temp != null ? temp.next : temp;
                        head = temp;
                }
                return clonedListHead;
        }
        
        private static void setRandomPointers(LinkedListNode current) {
                // set cloned list's node random pointer
                while (current != null) {
                        current.next.random = current.random.next;
                        current = current.next.next;
                }
        }
        
        private static LinkedListNode cloneList(LinkedListNode head) {
                LinkedListNode originalCurr;
                originalCurr = head;
                // create new node and copy contents of current node into that and make it as it's next
                while (originalCurr != null) {
                        LinkedListNode temp = new LinkedListNode(originalCurr.data);
                        temp.next = originalCurr.next;
                        originalCurr.next = temp;
                        originalCurr = temp.next;
                }
                // set the random pointers of cloned list
                setRandomPointers(head);
                // get cloned list's head
                LinkedListNode clonedListHead = alternateSplitList(head);
                return clonedListHead;
        }
        
        public static void main(String[] args) {
                CloneListWithRandomPointerII obj = new CloneListWithRandomPointerII();
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
