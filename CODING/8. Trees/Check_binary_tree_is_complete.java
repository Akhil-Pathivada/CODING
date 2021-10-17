/*
Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.
A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Time Complexity : O(N)
Space Complexity : O(N)
*/

import java.util.*;

class Node {

	int data;
	Node left, right;

	public Node(int data) { 

		data = data;
		left = right = null;
	}
}

class BinaryTree {

	private static boolean isCompleteBT(Node root) {

		if(root == null) {
			return true;
		}

		Queue<Node> queue = new LinkedList<>();
		boolean isNonFullNode = false;

		queue.add(root);

		while(!queue.isEmpty()) {

			Node node = queue.remove();

			if(node.left != null) {

				if(isNonFullNode == true) {
					return false;
				}
				queue.add(node.left);
			}
			else {
				isNonFullNode = true;
			}

			if(node.right != null) {

				if(isNonFullNode == true) {
					return false;
				}
				queue.add(node.right);
			}
			else {
				isNonFullNode = true;
			}
		}
		return true;
	}

	public static void main(String args[]) {

        	Node root = new Node(1);
        	root.left = new Node(2);
        	root.right = new Node(3);
        	root.left.left = new Node(4);
        	root.left.right = new Node(5);
        	root.right.right = new Node(6);

        	System.out.println(isCompleteBT(root) ? "YES" : "NO");
	}
}