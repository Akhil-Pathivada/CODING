/*
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer ).
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted.

*/

class Node
{
	int data;
	Node right, down;
	
	Node(int item)
	{
		data = item;
		
		right = down = null;
	}
}

class LinkedList
{
	static Node push(Node head_ref, int item)
	{
		Node nn = new Node(item);
		
		nn.down = head_ref;
		
		head_ref = nn;
		
		return head_ref;
	}
	
	static Node Merge(Node a, Node b)
	{
		if(a == null)
			return b;
			
		if(b == null)
			return a; 
			
		Node res;
			
		if(a.data < b.data)
		{
			res = a;
			
			res.down = Merge(a.down, b);
		}
		else
		{
			res = b;
			
			res.down = Merge(a, b.down);
		}
		
		return res;
	}
	
	static Node Flatten(Node head)
	{
		if(head == null || head.right == null)
			return head;
		
		return Merge(head, Flatten(head.right));
	}
		
	public static void main(String args[])
	{
		Node head = null;
		
		head = push(head, 30);
		head = push(head, 8);
		head = push(head, 7);
		head = push(head, 5);
		
		head.right = push(head.right, 20);
		head.right = push(head.right, 10);
		
		head.right.right = push(head.right.right, 50);
		head.right.right = push(head.right.right, 22);
		head.right.right = push(head.right.right, 19);
		
		head.right.right.right = push(head.right.right.right,45);
		head.right.right.right = push(head.right.right.right,40);
		head.right.right.right = push(head.right.right.right,35);
		head.right.right.right = push(head.right.right.right,28);
		
		head = Flatten(head);
		
		for( ; head != null; head=head.down)
			System.out.print(head.data + " ");
	}
}
