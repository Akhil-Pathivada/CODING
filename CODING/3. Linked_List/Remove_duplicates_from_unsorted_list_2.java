/* 
 * Remove Duplicates from an Unsorted Linked List
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
import java.util.HashSet;

class Node{
	
	int data;
	Node next;

	public Node( int key){

		this.data = key;
		this.next = null;
	}
}

class LinkedList {
	
	private void printList( Node curr) {
		
		while (curr != null) {

			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}

	private void removeDuplicates( Node head) {
	
		Node prev, curr;
		prev = curr = head;

		HashSet<Integer> hs = new HashSet<>();

		while(curr != null) {

			if (hs.contains(curr.data)) {
				prev.next = curr.next;
			}
		       	else {
				hs.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	public static void main( String args[]){
		
		Node head = new Node(11);
		head.next = new Node(11);
		head.next.next = new Node(12);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(12);
		
		LinkedList obj = new LinkedList();
		obj.printList(head);

		obj.removeDuplicates(head);

		obj.printList(head);
	}	
}
