/* 
 * Given a singly linked list and an integer K, the task is to remove all the continuous set of nodes whose sum is K from the given linked list.
 * Print the updated linked list after the removal.
 * If no such deletion can occur, print the original Linked list.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *  */

import java.util.*;

class Node {

	int data;
	Node next;

	public Node(int data) {

		this.data = data;
		this.next = null;
	}
}

class LinkedList { 

	private void printList(Node curr) {

		while(curr != null) {

			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
	} 

	private Node deleteContinuousNodes(Node head, int K) {

		Node curr = head;
		Node temp = new Node(0);
		temp.next = head;

		Map<Integer, Node> hashMap = new HashMap<Integer, Node>();	
		
		int sum = 0;

		while(curr != null) {

			sum += curr.data;

			if(hashMap.containsKey(sum - K)) {
				
				Node prev = hashMap.get(sum - K);
				Node start = prev.next;

				int aux = sum; 
				sum = sum - K;

				while(start != curr.next) {

					aux += start.data;
					hashMap.remove(aux);
					start = start.next;
				} 
				prev.next = curr.next;
			}
			else if(!hashMap.containsKey(sum - K)) {

				hashMap.put(sum, curr);
			}

			curr = curr.next;
		}
		return temp.next;
	}

	public static void main(String args[]) {

		Node head = new Node(7);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);

		int K = 6;

		LinkedList obj = new LinkedList();

		head = obj.deleteContinuousNodes(head, K);
		obj.printList(head);
	}
}
