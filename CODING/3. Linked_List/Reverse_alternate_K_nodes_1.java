/*
Given a linked list, write a function to reverse every alternate k nodes 

Input: 1->2->3->4->5->6->7->8->9  and  k = 3
Output: 3->2->1->4->5->6->9->8->7 

Method-1 : Process 2k nodes and recursively call for rest of the list
Time Complexity : O(n)
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
	Node head;
	
	void push(int item)
	{
		Node nn = new Node(item);
		
		nn.next = head;
		
		head = nn;
	}
	
	Node reverseAlternateNodes(Node head, int k)
	{
		int count = 0;
		
		Node currPtr = head;
		
		Node nextPtr, prevPtr = null;
		
		while(currPtr != null && count < k)
		{
			nextPtr = currPtr.next;
			
			currPtr.next = prevPtr;
			
			prevPtr = currPtr;
			
			currPtr = nextPtr;
			
			++count;
		}
		
		if(head != null)
			head.next = currPtr;
		
		count = 1;
		
		while(count < k && currPtr != null)
		{	
			++count;
			
			currPtr = currPtr.next;
		}
		
		if(currPtr != null)
			currPtr.next = reverseAlternateNodes(currPtr.next, k);
		
		return prevPtr;
	}
		
	void printList(Node curr)
	{
		for( ; curr != null; curr=curr.next)
			System.out.print(curr.data + " ");
	}
	
	public static void main(String args[])
	{	
		LinkedList ob = new LinkedList();
		
		for(int i=9; i>0; --i)
			ob.push(i);
			
		//ob.printList(ob.head);
		
		int k = 3;
		
		ob.head = ob.reverseAlternateNodes(ob.head, k);
		
		ob.printList(ob.head);
	}
}
