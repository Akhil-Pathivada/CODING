/* Program to get the vertical order of the Binary Tree.....

Here,we are using a DLL instead of HashTable..,which can grow dynamically

Time Complexity : O(n)
Space Complexity : O(n)
*/
class Node
{
	int data;
	Node left, right, link;
	
	Node(int item)
	{
		data = item;
		
		left = right = link = null;
	}
}

class BinaryTree
{
	void makeNextNode(Node root, Node head)
	{
		Node nn = new Node(root.data);
		
		if(head.right != null)
		{
			Node temp = head.right.link;
			
			head.right.link = nn;
			
			nn.link = temp;
			
			return;
		}
		
		head.right = nn;
		
		nn.left = head;
	}
	
	void makePrevNode(Node root, Node head)
	{
		Node nn = new Node(root.data);
		
		if(head.left != null)
		{
			Node temp = head.left.link;
			
			head.left.link = nn;
			
			nn.link = temp;
			
			return;
		}
		
		head.left = nn;
		
		nn.right = head;
	}	
	
	void getVerticalOrder(Node root, Node head)
	{
		if(root.left != null)
		{
			makePrevNode(root.left, head);
			
			getVerticalOrder(root.left, head.left);
		}
		
		if(root.right != null)
		{
			makeNextNode(root.right, head);
			
			getVerticalOrder(root.right, head.right);
		}
	}
	
	void printVerticalOrder(Node root)
	{
		Node head = new Node(root.data);
		
		getVerticalOrder(root, head);
		
		while(head.left != null)
			head = head.left;
			
		for( ; head != null; head=head.right)
		{
			Node curr = head;

			for( ; curr != null; curr=curr.link)
				System.out.print(curr.data + " ");
		}
	}
	
	public static void main(String args[])
	{
		BinaryTree ob = new BinaryTree();
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(3);
		root.left.left.right.left = new Node(39);
		root.left.left.right.right = new Node(19);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.left.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.left.left = new Node(95);
		root.right.right.left.right = new Node(99);
		root.right.right.right = new Node(100);
		
		ob.printVerticalOrder(root);
	}
}
