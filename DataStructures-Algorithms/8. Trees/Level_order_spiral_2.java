/*
Level Order traversal in a Spiral form

Using One Deque....

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
		Deque<Node> deque = new LinkedList<Node>();
		
		deque.addFirst(root);
		
		int count = 1;
		
		boolean flag = true;
		
		while(!deque.isEmpty())
		{
			
			int currentCount = 0;
			
			while(count > 0)
			{
				Node temp;
				
				if(flag)
				{
					temp = deque.pollFirst();
					
					System.out.print(temp.data + " ");
					
					if(temp.left != null)
					{
						deque.offerLast(temp.left);
						
						currentCount++;
					}
					if(temp.right != null)
					{
						deque.offerLast(temp.right);
						
						currentCount++;
					}
				}
				else
				{
					temp = deque.pollLast();
					
					System.out.print(temp.data + " ");
					
					if(temp.right != null)
					{
						deque.offerFirst(temp.right);
						
						currentCount++;
					}
					if(temp.left != null)
					{
						deque.offerFirst(temp.left);
						
						currentCount++;
					}
				}
				
				count--;
			}
			
			count = currentCount;
			
			flag = !flag;
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
