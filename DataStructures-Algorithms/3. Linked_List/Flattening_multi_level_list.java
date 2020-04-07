/*
Given a linked list where in addition to the next pointer, each node has a child pointer, which may or may not point to a separate list. 
These child lists may have one or more children of their own, and so on, to produce a multilevel data structure.You are given the head of 
the first level of the list. Flatten the list so that all the nodes appear in a single-level linked list. You need to flatten the list 
in way that all nodes at first level should come first, then nodes of second level, and so on.

*/

class Node
{
	int data;
	Node next, child;
	
	Node(int item)
	{
		data = item;
		
		next = child = null;
	}
}

class LinkedList
{
	Node getTail(Node head)
	{
		if(head == null)
			return null;
		
		while(head.next != null)
			head = head.next;
		
		return head;
	}
	
	void flattenList(Node head)
	{
		if(head == null)
			return;
			
		Node curr =  head;
		
		Node tail = getTail(head);
		
		while(curr != tail)
		{
			if(curr.child != null)
			{
				tail.next = curr.child;
				
				tail = getTail(curr.child);
			}
			
			curr = curr.next;
		}
	}
	
	Node createList(int arr[], int n)
	{
		Node head = null;
		
		Node p = head;
		
		for(int i=0; i<n; ++i)
		{
			if(head == null)
				head = p = new Node(arr[i]);
			else
			{
				p.next =  new Node(arr[i]);;
				
				p = p.next;
			}
		}
		return head;
	}
	
	Node createList()
	{
		int arr1[] = {10, 5, 12, 7, 11};
		int arr2[] = {4, 20, 13};
		int arr3[] = {17, 6};
		int arr4[] = {9, 8};
		int arr5[] = {19, 15};
		int arr6[] = {2};
		int arr7[] = {16};
		int arr8[] = {3};
		
		Node head1, head2, head3, head4, head5, head6, head7, head8;
		
		head1 = createList(arr1, arr1.length);
		head2 = createList(arr2, arr2.length);
		head3 = createList(arr3, arr3.length);
		head4 = createList(arr4, arr4.length);
		head5 = createList(arr5, arr5.length);
		head6 = createList(arr6, arr6.length);
		head7 = createList(arr7, arr7.length);
		head8 = createList(arr8, arr8.length);
		
		head1.child = head2;
		head1.next.next.next.child = head3;
		head2.next.child = head6;
		head2.next.next.child = head7;
		head7.child = head8;
		head3.child = head4;
		head4.child = head5;
		
		return head1;
	}
	
	public static void main(String args[])
	{
		LinkedList ob = new LinkedList();
		
		Node head = null;
		
		head = ob.createList();
		
		ob.flattenList(head);
		
		for( ; head != null; head=head.next)
			System.out.print(head.data + " ");
	}
}
