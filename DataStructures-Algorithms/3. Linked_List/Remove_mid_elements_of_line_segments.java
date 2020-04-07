/*
Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line (line segments). 
Delete points from the linked list which are in the middle of a horizontal or vertical line.

Time Complexity : O(n)
Space Complexity : O(1)
*/

class Node
{
	int x, y;
	Node next = null;
	
	Node(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

class LinkedList
{
	Node head;
	
	void push(int x, int y)
	{
		Node nn = new Node(x, y);
		
		nn.next = head;
		
		head = nn;
	}
	
	void removeMiddleElements(Node curr)
	{
		if(curr == null || curr.next == null)
			return;
			
		Node sNext = curr.next;
		
		Node nextNext = sNext.next; 
		
		if(curr.x == sNext.x)
		{
			while(nextNext != null && sNext.x == nextNext.x)
			{
				curr.next = nextNext;
				
				sNext.next = null;
				
				sNext = nextNext;
				
				nextNext = nextNext.next;
			}
		}
		
		if(curr.y == sNext.y)
		{
			while(nextNext != null && sNext.y == nextNext.y)
			{
				curr.next = sNext.next;
				
				sNext.next = null;
				
				sNext = nextNext;
				
				nextNext = nextNext.next;
			}
		}
		
		removeMiddleElements(curr.next);
	}
	
	public static void main(String args[])
	{
		LinkedList ob = new LinkedList();	
			
        	ob.push(40,5); 
        	ob.push(20,5); 
        	ob.push(10,5); 
        	ob.push(10,8); 
        	ob.push(10,10); 
        	ob.push(3,10); 
        	ob.push(1,10); 
        	ob.push(0,10);
        	
        	ob.removeMiddleElements(ob.head);
        		
        	for(Node curr = ob.head ; curr != null; curr=curr.next)
        		System.out.print("(" + curr.x + "," + curr.y + ") ");
	}
}
