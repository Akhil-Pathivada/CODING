/*
Given a singly linked list 1->2->3->4->5. 
Rearrange the nodes, so that the new list is : 1 -> 5 -> 2 -> 4 -> 3 

Time Complexity : O(n)
Space Complexity : O(1)
*/

class Node {

	int data;
	Node next;
	
	Node(int item) {

		data = item;
		next = null;
	}
}

class LinkedList {	

	Node mergeAlternates( Node head1, Node head2) {

		Node dummyHead = new Node(0);
		Node current = dummyHead;
		
		while(head1 != null && head2 != null) {

			current.next = head1;
			head1 = head1.next;
			current = current.next;
			current.next = head2;
			head2 = head2.next;
			current = current.next;
		}
		current.next = head1;
		
		return dummyHead.next;
	}
	
	Node getMidNode(Node head) {

		Node slowPtr = head;
		Node fastPtr = head.next;
		
		while(fastPtr != null && fastPtr.next != null) {

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		Node next = slowPtr.next;
		slowPtr.next = null;
		
		return next;
			
	}
	
	Node Reverse(Node currPtr) {	

		Node prevPtr = null;
		
		while(currPtr != null) {

			Node nextPtr = currPtr.next;
			currPtr.next = prevPtr;
			prevPtr = currPtr;
			currPtr = nextPtr;
		}
		return prevPtr;
	}
	
	Node reOrderList(Node head) {

		Node mid = getMidNode(head);
		mid = Reverse(mid);
			
		return mergeAlternates(head, mid);
	}
	
	public static void main(String args[]) {

		LinkedList ob = new LinkedList();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
	
		head = ob.reOrderList(head);
		
		for( ; head != null; head = head.next)
			System.out.print(head.data + " ");
	}
}
