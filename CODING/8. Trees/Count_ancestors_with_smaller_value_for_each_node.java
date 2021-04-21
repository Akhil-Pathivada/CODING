/* 
 * Given a Binary Tree consisting of N nodes, valued from 1 to N, rooted at node 1,
 * the task is for each node is to count the number of ancestors with value smaller than that of the current node.
 *
 *  */

import java.util.*;

class Node {

	int data;
	Node left, right;

	public Node(int data) { 

		this.data = data;
		left = right = null;
	}
}

class BinaryTree {

	public static void main(String args[]) {

		Node root = new Node('(');
		root.left = new Node('(');
		root.right = new Node(')');
		root.left.left = new Node('(');
		root.left.right = new Node(')');
		root.right.right = new Node('(');
	   	root.left.left.left = new Node('(');
		root.left.left.right = new Node('(');
		root.right.right.left = new Node(')');
		root.right.right.right = new Node(')');

		BinaryTree obj = new BinaryTree();
		System.out.println("Levels with Balanced Parenthesis: " + obj.checkParenthesisBalanced(root));
	}
}
