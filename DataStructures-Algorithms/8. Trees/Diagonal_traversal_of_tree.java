/*
Consider lines of slope -1 passing between nodes.
Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

Time Complexity : O(n)
Space Complexity : O(n)
*/

import java.util.*;
import java.util.Map.*; 

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
	void diagonalPrintUtil( Node root, int vd, HashMap<Integer, Vector<Integer>> hashMap)
	{
		if(root == null)
			return;
		
		Vector<Integer> k = hashMap.get(vd);
		
		if(k == null)
			k = new Vector<>();
		
		k.add(root.data);
		
		hashMap.put(vd, k);
		
		diagonalPrintUtil(root.left, vd+1, hashMap);
		
		diagonalPrintUtil(root.right, vd, hashMap);
	}	
	
	void diagonalPrint(Node root)
	{
		HashMap<Integer, Vector<Integer>> hashMap = new HashMap<>();
		
		diagonalPrintUtil(root, 0, hashMap);
		
		for(Entry<Integer, Vector<Integer>> entry : hashMap.entrySet())
			System.out.print(entry.getValue());
	}
	
	public static void main(String args[])
	{
		BinaryTree ob = new BinaryTree();
		 
        	Node root = new Node(8); 
        	root.left = new Node(3); 
        	root.right = new Node(10); 
        	root.left.left = new Node(1); 
        	root.left.right = new Node(6); 
        	root.right.right = new Node(14); 
        	root.right.right.left = new Node(13); 
        	root.left.right.left = new Node(4); 
        	root.left.right.right = new Node(7); 
        	
        	ob.diagonalPrint(root);
	}
}
