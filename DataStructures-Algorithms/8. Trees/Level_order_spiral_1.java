/*
Level Order traversal in a Spiral form

Using Two Stacks....

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
	void LevelOrderSpiral(Node root)
	{
		Stack<Node> s1 = new Stack<Node>();
		
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			Node temp;
			
			while(!s1.isEmpty())
			{
				temp = s1.pop();
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					s2.push(temp.left);
				
				if(temp.right != null)
					s2.push(temp.right);
			}
			while(!s2.isEmpty())
			{
				temp = s2.pop();
				
				System.out.print(temp.data + " ");
				
				if(temp.right != null)
					s1.push(temp.right);
				
				if(temp.left != null)
					s1.push(temp.left);
			}
		}
 	}
	
	public static void main(String args[])
	{
		BinaryTree ob = new BinaryTree();
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);	
		root.right.right.right = new Node(90);	
		root.right.right.left = new Node(89);	
		root.left.left.left = new Node(120);
		root.left.left.right = new Node(125);
		
		ob.LevelOrderSpiral(root);
	}
}
