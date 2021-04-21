/*
Level Order Traversal of a Binary Tree....

Time Complexity : O(n)
Space Complexity : O(n)
*/
import java.util.*;

class node
{
	int data;
	
	node left,right;
	
	public node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	node root;
	
	void LevelOrder(node root)
	{
		Queue<node> queue = new LinkedList<node>();
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			node temp = queue.poll();
			
			if(temp.left != null)
				queue.add(temp.left);
			
			if(temp.right != null)
				queue.add(temp.right);
			
			System.out.print(temp.data + " ");
		}
	}
	
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		
		tree.root = new node(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		tree.root.right.left = new node(6);
		tree.root.right.right = new node(7);
		
		tree.LevelOrder(tree.root);
	}
}
