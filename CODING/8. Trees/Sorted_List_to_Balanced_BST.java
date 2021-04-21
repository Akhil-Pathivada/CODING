/*
Given a Singly Linked List which has data members sorted in ascending order. 
Construct a Balanced Binary Search Tree which has same data members as the given Linked List. 

Time Complexity : O(n)
Space Complexity : O(n)
*/
import java.util.*;

class Lnode
{
	int data;
	Lnode next;
	
	Lnode(int item)
	{
		data = item;
		
		next = null;
	}
}

class Bnode
{
	int data;
	Bnode left, right;
	
	Bnode(int item)
	{
		data = item;
		
		left = right = null;
	}
}

class BinaryTree
{
	Lnode head;
	
	int getCount(Lnode head)
	{
		int count = 0;
		
		for( ; head != null; head=head.next)
			++count;
		
		return count;
	}	
	
	Bnode sortedListToBSTRecur(int n)
	{
		if(n <= 0)
			return null;
		
		Bnode leftTree = sortedListToBSTRecur(n/2);
		
		Bnode root = new Bnode(head.data);
		
		root.left = leftTree;
		
		head = head.next;
		
		Bnode rightTree = sortedListToBSTRecur(n-n/2-1);
		
		root.right = rightTree;
		
		return root;
	}
	
	Bnode sortedListToBST()
	{
		int count = getCount(head);
		
		return sortedListToBSTRecur(count);
	}
	
	void PreOrder(Bnode root)
	{
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		
		PreOrder(root.left);
		
		PreOrder(root.right);
	}
	
	public static void main(String args[])
	{
		BinaryTree ob = new BinaryTree();
		
		ob.head = new Lnode(1);
		ob.head.next = new Lnode(2);
		ob.head.next.next = new Lnode(3);
		ob.head.next.next.next = new Lnode(4);
		ob.head.next.next.next.next = new Lnode(5);
		ob.head.next.next.next.next.next = new Lnode(6);
		ob.head.next.next.next.next.next.next = new Lnode(7);
		
		Bnode root = ob.sortedListToBST();
		
		ob.PreOrder(root);
	}
}
