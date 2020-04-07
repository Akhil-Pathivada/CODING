/*
Given a linked list, write a function to reverse every alternate k nodes 

Input: 1->2->3->4->5->6->7->8->9  and  k = 3
Output: 3->2->1->4->5->6->9->8->7 

Method-2 : Process k nodes and recursively call for rest of the list
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
	
	Node reverseAlternateNodes(Node head, int k, boolean flag)
	{
		if(head == null)
			return null;
		
		int count = 0;
		
		Node currPtr = head;
		
		Node nextPtr, prevPtr = null;
		
		while(currPtr != null && count < k)
		{
			nextPtr = currPtr.next;
			
			if(flag == true)
				currPtr.next = prevPtr;
			
			prevPtr = currPtr;
			
			currPtr = nextPtr;
			
			++count;
		}
		
		if(flag)
		{
			head.next = reverseAlternateNodes(currPtr, k, !flag);
			
			return prevPtr;
		}
		else
		{
			prevPtr.next = reverseAlternateNodes(currPtr, k, !flag);
			
			return head;
		}
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
		
		ob.head = ob.reverseAlternateNodes(ob.head, k, true);
		
		ob.printList(ob.head);
	}
}
