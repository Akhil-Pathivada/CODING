/**
 * Removing the Loop in the Linked List
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class RemoveCycle {
        
        private void removeCycle(LinkedListNode head, LinkedListNode nodeInCycle) {
                // point slow pointer to head and fastPtr to node in cycle
                LinkedListNode slowPtr, fastPtr;
                slowPtr = head;
                fastPtr = nodeInCycle;
                // intersection point of both next pointers should be the start node of cycle
                while(slowPtr.next != fastPtr.next) {
                        slowPtr = slowPtr.next;
                        fastPtr = fastPtr.next;
                }
                fastPtr.next = null;
        }
        
        private LinkedListNode getNodeInCycle(LinkedListNode head) {
                // point both slow, fast pointers to head
                LinkedListNode slowPtr, fastPtr;
                slowPtr = fastPtr = head;
                // slowPtr is a walker, whereas fastPtr is a runner
                while (fastPtr != null && fastPtr.next != null) {
                        slowPtr = slowPtr.next;
                        fastPtr = fastPtr.next.next;
                        // cycle is found
                        if(slowPtr == fastPtr) {
                                return slowPtr;
                        }
                }
                return null;
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(1);
                head.next = new LinkedListNode(2);
                head.next.next = new LinkedListNode(3);
                head.next.next.next = new LinkedListNode(4);
                head.next.next.next.next = new LinkedListNode(5);
                head.next.next.next.next.next = new LinkedListNode(6);
                head.next.next.next.next.next.next = head.next;
                new RemoveCycle().removeCycle(head, new RemoveCycle().getNodeInCycle(head));
                head.printLinkedList(head);
        }
}
