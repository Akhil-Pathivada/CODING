/*
Print cousins of a given node in Binary Tree (Single Traversal)

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
	void printCousins( Node root, Node targetNode)
	{
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		boolean found = false;
		
		while(!queue.isEmpty() && found == false)
		{
			int size = queue.size();
			
			while(size-- != 0)
			{
				Node temp = queue.poll();
				
				if(temp.left == targetNode || temp.right == targetNode)
					found = true;
				else
				{
					if(temp.left != null)
						queue.add(temp.left);
					
					if(temp.right != null)
						queue.add(temp.right);
				}		
			}
		}
		
		while(!queue.isEmpty())
			System.out.print(queue.poll().data + " ");
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
		root.left.left.left = new Node(120);	

		Node targetNode = root.right.right;

		ob.printCousins(root, targetNode);
	}
}
