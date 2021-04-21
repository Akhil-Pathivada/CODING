/*
Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent.
In a Binary Tree, there can be at most one sibling). Root should not be printed as root cannot have a sibling.

Time Complexity : O(n)
Space Complexity : O(n)
*/

class Node
{
	int data;
	Node left, right;
	
	Node(int data)
	{	
		this.data = data;
		
		left = right = null;
	}
}

class BinaryTree
{
	static void printSingles(Node root)
	{
		if(root == null)
			return;
		
		if(root.left == null ^ root.right == null)
			System.out.print(root.left != null ? root.left.data : root.right.data);
		
		printSingles(root.left);
		
		printSingles(root.right);
	}
	
	public static void main(String args[])
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.left.left = new Node(6);
		
		printSingles(root);
	}
}
