/*
Given a binary tree, we need to check it has heap property or not, Binary tree need to fulfill the following two conditions for being a heap –

   1.It should be a complete tree (i.e. all levels except last should be full).
   2.Every Node’s value should be greater than or equal to its child Node (considering max-heap).

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
	boolean isHeap(Node root)
	{
		if(root.left == null && root.right == null)
			return true;
			
		if(root.right == null)
			return root.data >= root.left.data;
		
		return root.data >= root.left.data && root.data >= root.right.data &&
		       isHeap(root.left) && 
		       isHeap(root.right);	
	}
	
	boolean isCompleteBT(Node root)
	{
		if(root == null)
			return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		boolean flag = false;
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			
			if(temp.left != null)
			{
				if(flag == true)
					return false;
				
				queue.add(temp.left);
			}
			else
				flag = true;
			
			if(temp.right != null)
			{
				if(flag == true)
					return false;
				
				queue.add(temp.right);
			}
			else
				flag = true;
		}
		return true;
	}	
	
	boolean isMaxHeapUtil(Node root)
	{	
		return (isCompleteBT(root) == true && isHeap(root) == true) ? true : false;  
	}
	
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		
		Node root;
		root = new Node(10);
		root.left = new Node(9);
		root.right = new Node(8);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(1);
		
		System.out.println(tree.isMaxHeapUtil(root) ? "Yes" : "No");
	}
}
