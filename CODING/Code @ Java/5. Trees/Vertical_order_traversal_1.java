/* Program to get the vertical order of the Binary Tree.....

Time Complexity : O(n*k)....where 'k' is the range of Horizantal distance
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
	int min = 0, max = 0;
	
	void printElements( Node root, int order, int count)
	{
		if(root == null)
			return;
		
		if(count == order)
			System.out.print(root.data + " ");
		
		printElements(root.left, order, count-1);
		
		printElements(root.right, order, count+1);
	}
	
	void getMinMax( Node root, int vcount)
	{
		if(root == null)
			return;
		
		if(vcount < min)
			min = vcount;
		
		if(vcount > max)
			max = vcount;
		
		getMinMax(root.left, vcount-1);
		
		getMinMax(root.right, vcount+1);
	}
	
	void printVerticalOrder(Node root)
	{
		getMinMax(root, 0);
		
		for(int i=min; i<=max; ++i)
			printElements(root, i, 0);
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
