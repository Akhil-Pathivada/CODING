/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package linkedlist;

public class AddTwoNumbers extends LinkedListNode {
        
        private LinkedListNode addNumbers(LinkedListNode l1, LinkedListNode l2) {
                LinkedListNode dummy = new LinkedListNode(0); // creating an dummy list
                LinkedListNode current = dummy;
                int carry = 0; // intialising our carry with 0 intiall
                // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
                // We will add that as well into our list
                while (l1 != null || l2 != null || carry == 1) {
                        int sum = 0;
                        // adding l1 to our sum & moving l1
                        if (l1 != null) {
                                sum += l1.data;
                                l1 = l1.next;
                        }
                        // adding l2 to our sum & moving l2
                        if (l2 != null) {
                                sum += l2.data;
                                l2 = l2.next;
                        }
                        sum += carry; // if we have carry then add it into our sum
                        carry = sum / 10; // if we get carry, then divide it by 10 to get the carry
                        current.next = new LinkedListNode(sum % 10);  // the value we'll get by moduloing it, will become as new node so. add it to our list
                        current = current.next; // update the current every time
                }
                return dummy.next;
        }
        
        public static void main(String[] args) {
                LinkedListNode list1 = new LinkedListNode(9);
                list1.next = new LinkedListNode(9);
                list1.next.next = new LinkedListNode(9);
                list1.next.next.next = new LinkedListNode(9);
                list1.next.next.next.next = new LinkedListNode(9);
                list1.next.next.next.next.next = new LinkedListNode(9);
                list1.next.next.next.next.next.next  = new LinkedListNode(9);
                LinkedListNode list2 = new LinkedListNode(9);
                list2.next = new LinkedListNode(9);
                list2.next.next = new LinkedListNode(9);
                list2.next.next.next = new LinkedListNode(9);
                new LinkedListNode().printLinkedList(new AddTwoNumbers().addNumbers(list1, list2));
        }
}
