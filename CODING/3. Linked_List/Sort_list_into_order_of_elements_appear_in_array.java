/* 
 * Given an array of size N and a Linked List where elements will be from the array but can also be duplicated, sort the linked list in the order,
 * elements are appearing in the array.
 * It may be assumed that the array covers all elements of the linked list.
 *
 * https://www.geeksforgeeks.org/sort-linked-list-order-elements-appearing-array/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *  */

import java.util.*;

class Node {

	int data;
	Node next;
	
	Node(int data) {

		this.data = data;
		next = null;
	}
}

class LinkedList {

	void sortList(int arr[], int N, Node head) {

		// Store the elements, frequencies of elements in a hash table.
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();

		Node curr = head;

		while(curr != null) {

			if(hashMap.containsKey(curr.data)) {
				hashMap.put(curr.data, hashMap.get(curr.data) + 1);
			}
			else { 
				hashMap.put(curr.data, 1);
			}
			curr = curr.next;
		}
		curr = head;

		// One by one put elements in lis according to their appearance in array
		for(int i = 0; i < N; ++i) {

			int frequency = hashMap.get(arr[i]);
			while(frequency-->0) {

				curr.data = arr[i];
				curr = curr.next;
			}
		}
	}

	private void printList(Node head) {

		while(head != null) {
			System.out.print(head.data + ", ");
			head = head.next;
		}
	}

	public static void main(String args[]) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(5);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(3);

		LinkedList obj = new LinkedList();

		int arr[] = { 5, 1, 3, 2, 8 };
		int N = arr.length;
 		 
		obj.sortList(arr, N, head);
		System.out.print("Sorted List: ");

		obj.printList(head);
	}
}
