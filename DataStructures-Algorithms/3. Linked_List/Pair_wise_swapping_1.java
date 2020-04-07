/*
Pairwise swap elements of a given linked list by changing links

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
	Node head;

	void push(int data)
	{
		Node nn = new Node(data);
		
		nn.next = head;
		
		head = nn;
	}	
		
	Node pairWiseSwap(Node head)
	{	
		Node prev = head;
		
		head = head.next;
		
		Node curr = head;
		
		while(true)
		{
			Node nextPtr = curr.next;
			
			curr.next = prev;
			
			if(nextPtr == null || nextPtr.next == null)
			{
				prev.next = nextPtr;
				
				break;
			}
			
			prev.next = nextPtr.next;
			
			prev = nextPtr;
			
			curr = prev.next;
		}
		
		return head;
	}
	
	void printList()
	{
		Node curr = head;
		
		for( ; curr != null; curr=curr.next)
			System.out.print(curr.data + " ");
	}
	
	public static void main(String args[])
	{
		LinkedList ob = new LinkedList();
		
		ob.push(8);
		ob.push(7);
		ob.push(6);
		ob.push(5);
		ob.push(4);
		ob.push(3);
		ob.push(2);
		ob.push(1);
	
		ob.head = ob.pairWiseSwap(ob.head);
		
		ob.printList();
	}
}
