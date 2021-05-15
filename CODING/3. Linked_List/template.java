
class Node {

	int data;
	Node next;
	
	Node(int data) {

		this.data = data;
		next = null;
	}
}

private void printList(Node head) {

	while(head != null) {
		System.out.print(head.data + ", ");
		head = head.next;
	}
}
