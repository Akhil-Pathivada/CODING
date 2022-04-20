/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package linkedlist;

public class StartNodeOfCycleI {
        
        private int getStartNodeOfCycle(LinkedListNode head, LinkedListNode nodeInCycle) {
                // point both pointers to the node in cycle
                LinkedListNode ptr1, ptr2;
                ptr1 = ptr2 = nodeInCycle;
                // find the length of cycle
                int lengthOfCycle = 1;
                while(ptr2.next != ptr1) {
                        ++lengthOfCycle;
                        ptr2 = ptr2.next;
                }
                // keep ptr1 at head && ptr2 at K nodes after head
                ptr1 = ptr2 = head;
                for(int i = 0; i < lengthOfCycle; ++i) {
                        ptr2 = ptr2.next;
                }
                // intersection point of both pointers should be the start node of cycle
                while(ptr1 != ptr2) {
                        ptr1 = ptr1.next;
                        ptr2 = ptr2.next;
                }
                return ptr1.data;
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
                System.out.println(new StartNodeOfCycleI().getStartNodeOfCycle(head, new StartNodeOfCycleI().getNodeInCycle(head)));
        }
}
