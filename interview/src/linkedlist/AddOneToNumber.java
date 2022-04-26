/**
 * Date 12/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class AddOneToNumber {
        
        private LinkedListNode reverse(LinkedListNode head) {
                LinkedListNode curr = head, prev = null, next;
                while (curr != null) {
                        next = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = next;
                }
                return prev;
        }
        
        private LinkedListNode addOne(LinkedListNode head) {
                head = reverse(head);
                LinkedListNode curr = head, prev = null;
                int carry = 1;
                while (curr != null) {
                        int sum = carry + curr.data;
                        carry = sum / 10;
                        curr.data = sum % 10;
                        prev = curr;
                        curr = curr.next;
                        if (carry == 0) {
                                break;
                        }
                }
                if (carry == 1) {
                        prev.next = new LinkedListNode(1);
                }
                return reverse(head);
        }
        
        public static void main(String[] args) {
                LinkedListNode head = new LinkedListNode(9);
                head.next = new LinkedListNode(9);
                head.next.next = new LinkedListNode(9);
                head.next.next.next = new LinkedListNode(9);
                head = new AddOneToNumber().addOne(head);
                head.printLinkedList(head);
        }
}
