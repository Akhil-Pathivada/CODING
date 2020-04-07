/*
Sort the given biotonic doubly linked list. A biotonic doubly linked list
is a doubly linked list which is first increasing and then decreasing. 
A strictly increasing or a strictly decreasing list is also a biotonic doubly linked list.

Time Complexity : O(n)
Space Complexity : O(1)
*/

class Node
{
	int data;
	Node prev, next;

	Node(int data)
	{
		this.data = data;
		prev = next = null;
	}
}

class DoubleLinkList
{
	Node Push(Node head, int data)
	{
		Node nn = new Node(data);

		if(head != null)
		{
			nn.next = head;

			head.prev = nn;
		}

		head = nn;

		return head;
	}

	void printList( Node head)
	{
		while(head != null)
		{
			System.out.print(head.data + "->");

			head = head.next;
		}

		System.out.println();
	}

	Node mergeSortedLists( Node curr1, Node curr2)
	{
		Node mergePtr, resultHead;

		if(curr1.data < curr2.data)
		{
			mergePtr = curr1;

			curr1 = curr1.next;
		}
		else
		{
			mergePtr = curr2;

			curr2 = curr2.next;
		}

		resultHead = mergePtr;

		while(curr1 != null && curr2 != null)
		{
			if(curr1.data < curr2.data)
			{
				mergePtr.next = curr1;

				curr1 = curr1.next;
			}
			
			else
			{
				mergePtr.next = curr2;

				curr2 = curr2.next;
			}

			mergePtr = mergePtr.next;
		}

		mergePtr.next = (curr1 != null) ? curr1 : curr2;

		return resultHead; 
	}

	Node Reverse( Node curr)
	{
		Node temp = null;

		while(curr != null)
		{
			temp = curr.prev;

			curr.prev = curr.next;

			curr.next = temp;

			curr = curr.prev;
		}
		
		return temp != null ? temp.prev : temp;	
	}

	Node sortBitonicList( Node head)
	{
		if(head == null || head.next == null)
			return head;

		Node curr = head.next;

		while(curr != null && curr.data > curr.prev.data)
			curr = curr.next;

		if(curr == null)
			return head;

		curr.prev.next = null;

		curr.prev = null;

		curr = Reverse(curr);

		return mergeSortedLists(head, curr);
	}

	public static void main(String args[])
	{
		DoubleLinkList ob = new DoubleLinkList();

		Node head = null;

		head = ob.Push(head, 3);
		head = ob.Push(head, 4);
		head = ob.Push(head, 5);
		head = ob.Push(head, 7);
		head = ob.Push(head, 6);
		head = ob.Push(head, 2);
		head = ob.Push(head, 1);

		ob.printList(head);

		head = ob.sortBitonicList(head);

		ob.printList(head);
	}
}