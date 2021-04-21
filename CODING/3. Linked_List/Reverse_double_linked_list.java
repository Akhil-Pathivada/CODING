/*
Reverse Doubly Linked List....

Time Complexity : O(n)
Space Complexity : O(1)
*/

class Node
{
	int data;
	Node prev, next;
	
	Node(int item)
	{
		data = item;
		
		prev = next = null;
	}
}

class LinkedList
{
	Node head;
	
	void push(int data)
	{
		Node nn = new Node(data);
		
		nn.next = head;
		
		if(head != null)
			head.prev = nn;
			
		head = nn;
	}
	
	void printList()
	{
		Node curr = head;
		
		for( ; curr!=null; curr=curr.next)
			System.out.print(curr.data + " ");
	}
	
	void reverseList()
	{
		Node curr = head;
		
		Node temp = null;
		
		while(curr != null)
		{
			temp = curr.prev;
			
			curr.prev = curr.next;
			
			curr.next = temp;
			
			curr = curr.prev;
		}
		
		if(temp != null)
			head = temp.prev;
	}
	
	public static void main(String args[])
	{	
		LinkedList ob = new LinkedList();
		
		ob.push(1);
		ob.push(2);
		ob.push(3);
		ob.push(4);
		ob.push(5);
		ob.push(6);
		
		ob.reverseList();
		
		ob.printList();
	}
}
