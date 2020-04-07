/*
Given a binary tree, a target node in the binary tree, and an integer value k, 
print all the nodes that are at distance k from the given target node. 

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
	static void findInChild( Node root, int k)
	{
		if(root == null || k < 0)
			return;
		
		if(k==0)
		{
			System.out.print(root.data + " ");
			
			return;
		}
		
		findInChild(root.left, k-1);
		
		findInChild(root.right, k-1);
	}
	
	static int printNodes( Node root, int target, int k)
	{
		if(root == null)
			return -1;
		
		if(root.data == target)
		{
			findInChild(root, k);
			
			return 0;
		}
		
		int dl = printNodes(root.left, target, k);
		
		if(dl != -1)
		{
			if(dl + 1 == k)
				System.out.print(root.data + " ");
			else
				findInChild(root.right, k-dl-2);
				
			return 1 + dl;
		}
		
		int dr = printNodes(root.right, target, k);
		
		if(dr != -1)
		{
			if(dr + 1 == k)
				System.out.print(root.data + " ");
			else
				findInChild(root.left, k-dr-2);
				
			return 1 + dr;
		}
		
		return -1;
	}
	
	public static void main(String args[])
	{
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		int target = 12;
		
		int k = 2;
		
		printNodes(root, target, k);
	}
}
