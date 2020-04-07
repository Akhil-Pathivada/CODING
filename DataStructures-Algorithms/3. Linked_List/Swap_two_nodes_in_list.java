/*
Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. 

Time Complexity : O(n)
Space Complexity : O(1)
*/ 

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		
		next = null;
	}
}

class LinkedList
{
	Node head;
	
	void swapTwoNodes(int x, int y)
	{
		Node currX, currY, prevX, prevY;
		
		currX = currY = head;
		
		prevX = prevY = null;
		
		while(currX != null && currX.data != x)
		{
			prevX = currX;
			
			currX = currX.next;
		}

		while(currY != null && currY.data != y)
		{
			prevY = currY;
			
			currY = currY.next;
		}
		
		if(currX == null || currY == null)
			return;
		
		if(prevX == null)
			head = currY;	
		else
			prevX.next = currY;
		
		if(prevY == null)
			head = currX;
		else
			prevY.next = currX;
		
		Node temp = currX.next;
		
		currX.next = currY.next;
		
		currY.next = temp;
	}
	
	void push(int data)
	{
		Node nn = new Node(data);
		
		nn.next = head;
		
		head = nn;
	}
	
	public static void main(String args[])
	{		
		LinkedList ob = new LinkedList();
		
		ob.push(7);
		ob.push(6);
		ob.push(5);
		ob.push(4);
		ob.push(3);
		ob.push(2);
		ob.push(1);
		
		ob.swapTwoNodes(5, 7);
		
		Node curr = ob.head;
;		
		for( ; curr != null; curr=curr.next)
			System.out.print(curr.data + " ");
	}
}
