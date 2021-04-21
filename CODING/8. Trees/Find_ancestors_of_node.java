/*
Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree. 

Time Complexity : O(n)
Space Complexity : O(n)

*/

class Node
{
	int data;
	Node left, right;
	
	Node(int item)
	{
		data = item;
		
		left = right = null;
	}
}

class BinaryTree
{
	static boolean printAncestors( Node root, int target)
	{
		if(root == null)
			return false;
		
		if(root.data == target)
			return true;
		
		if(printAncestors(root.left, target) || printAncestors(root.right, target))
		{
			System.out.print(root.data + " ");
			
			return true;
		}
		
		return false;	
	}
	
	public static void main(String args[])
	{
		Node root = new Node(1); 
        	root.left = new Node(2); 
        	root.right = new Node(3); 
        	root.left.left = new Node(4); 
        	root.left.right = new Node(5); 
        	root.left.left.left = new Node(7);
        	
        	int key = 7;
        	
        	printAncestors(root, key); 
	}
}
