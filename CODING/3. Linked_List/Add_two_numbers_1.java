/* 
 * Given two numbers represented by two linked lists, write a function that returns the sum list.
 * The sum list is linked list representation of the addition of two input numbers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *  */

class Node { 
	int data;
	Node next;

	public Node(int value) {
		data = value;
		next = null;
	}
}

class LinkedList {
	
	LinkedList obj;
	Node head1, head2, resultList;
	head1 = head2 = resultList = null;

	// An utility function to push value into Linked List
	Node push(Node head, int data) {
		
		Node newNode = new Node(data);
		if(head != null) {
			newNode.next = head;
		}
		head = newNode;
		return head;
	}
	
	// Function to print LinkedList
	void printList(Node head) {

		for( ; head != null; head=head.next) {
			System.out.print(head.data + ", ");
		}
	}

	// return the size of the given list
	int getSize(Node head) {

		int count = 0;
		while(head != null) {
			++count;
			head = head.next;
		}
		return count;
	}
	
	// Adding the lists of same size
	void addSameSizeLists(Node m, Node n, int size1, int size2) {
		
		// since, both lists are of same size
		// checking with one list is enough
		if(head1 == null) {
			return;
		}
		int carry = addSameSizeLists(m.next, n.next);
		int sum = m.data + n.data + carry;
		sum = sum % 10;
		obj.push(obj.resultList, sum);
	} 

	// Method to add two lists
	Node addTwoLists(Node head1, Node head2) {
		
		// if one of the lists is empty:
		// return other one as result
		if(head1 == null) {
			return head2;
		}

		if(head2 == null) {
			return head1;
		}

		// record sizes of both lists
		int size1 = getSize(this.head1);
		int size2 = getSize(this.head2);

		// if both numbers contains
		// same number of digits
		if(size1 == size2) {
			addSameSizeLists(this.head1, this.head2);
			return;
		}

		if(size1 < size2) {

		}


	}

	public static void main(String args[]) {
		obj = new LinkedList();

		// pushing elements into two linked lists
		obj.head1 = obj.push(obj.head1, 9);		
		obj.head1 = obj.push(obj.head1, 9);		
		obj.head1 = obj.push(obj.head1, 9);		
		obj.head2 = obj.push(obj.head2, 1);		
		obj.head2 = obj.push(obj.head2, 8);		
		
		// printing intial two lists
		obj.printList(obj.head1);
		obj.printList(obj.head2);

		// calling method to add Lists
		resultList = obj.addTwoLists(obj.head1, obj.head2);
	}
}
