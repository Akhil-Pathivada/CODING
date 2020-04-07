/*
Given a Binary Tree, convert it into Doubly Linked List where the nodes are represented Spirally. 
The left pointer of the binary tree node should act as a previous node for created DLL and right pointer should act as next node.

Reference : https://www.geeksforgeeks.org/convert-a-binary-tree-into-doubly-linked-list-in-spiral-fashion/

Time Complexity : O(n)
Space Complexity : O(n)
*/
import java.util.*;

class Node
{
	int data;
	Node left, mid, right;

	Node(int data)
	{
		this.data = data;

		left = right = null;
	}
};

class BinaryTree
{
	Node head;

	void pushToList( Node nn)
	{
		if(head != null)
		{
			nn.right = head;

			head.left = nn;
		}

		head = nn;
	}

	void convertBTtoDLL( Node root)
	{
		if(root == null)
			return;

		Deque<Node> deque = new LinkedList<Node>();

		Stack<Node> stack = new Stack<Node>();

		deque.add(root);

		int level = 0;

		while(!deque.isEmpty())
		{
			int nodeCount = deque.size();
			if((level&1) == 0)
			{
				while(nodeCount > 0)
				{
					Node temp = deque.pollFirst();

					stack.push(temp);

					if(temp.left != null)
						deque.addLast(temp.left);

					if(temp.right != null)
						deque.addLast(temp.right);

					--nodeCount;
				}
			}
			else
			{
				while(nodeCount > 0)
				{
					Node temp = deque.pollLast();

					stack.push(temp);

					if(temp.right != null)
						deque.addFirst(temp.right);

					if(temp.left != null)
						deque.addFirst(temp.left);

					--nodeCount;
				}
			}

			++level;
		}

		while(!stack.isEmpty())
			pushToList(stack.pop());
	}

	void printDoubleList()
	{
		while(head != null)
		{
			System.out.print(head.data);

			head = head.right;
		}
	}

	public static void main(String args[])
	{
		BinaryTree ob = new BinaryTree();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.right.right.left = new Node(9);

		ob.convertBTtoDLL(root);

		ob.printDoubleList();
	}
}