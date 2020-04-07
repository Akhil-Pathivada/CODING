/*
Iterative implementation to get the Height of Binary Tree

Time Complexity : O(n)
Space Complexity : O(n)
*/

import java.util.*;

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
	static int getHeight(Node root)
	{
		int height = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		while(true)
		{
			int nodeCount = queue.size();
			
			if(nodeCount == 0)
				return height;
			
			height++;
			
			while(nodeCount > 0)
			{
				Node temp = queue.remove();
				
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
					
				nodeCount--;
			}
		}
	}
	
	public static void main(String args[])
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		System.out.println(getHeight(root));
	}
}
