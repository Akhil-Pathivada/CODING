/* 
 * Given a binary tree, the task is to print left and right leaf nodes separately.
 *
 * Input:
 *        0
 *      /   \
 *    1      2
 *  /  \
 * 3    4
 * Output:
 * Left Leaf Nodes: 3
 * Right Leaf Nodes: 4 2
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

		Node root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(9);
		root.left.left = new Node(4);
		root.left.right = new Node(10);
		root.right.right = new Node(6);

		BinaryTree obj = new BinaryTree();



	}
}
