/*
Given a Linked List and a number n, write a function that returns the value at the Kth node from the end of the Linked List.

Time Complexity : O(n)
Space Complexity : O(1)
*/

class Node
{
	int data;
	Node next;
	
	Node(int item)
	{
		data = item;
		
		next = null;
	}
}

class LinkedList
{	
	static int getNode(Node head, int k)
	{
		if(k==0 || head == null)
			return -1;
			
		Node slowPtr, fastPtr; 
		
		slowPtr = fastPtr = head;
		
		for(int i=0; i<k && fastPtr != null; ++i)
			fastPtr = fastPtr.next;
		
		if(fastPtr == null)	
			return -1;
		
		while(fastPtr != null)
		{
			slowPtr = slowPtr.next;
			
			fastPtr = fastPtr.next;
		}
		
		return slowPtr.data;
	}
	
	public static void main(String args[])
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		
		int k = 4;
		
		System.out.println(getNode(head, k));
	}
}

