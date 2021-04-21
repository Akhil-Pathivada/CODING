/** 
  * Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(N)
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
	
	private void printPreOrder(Node root) {

		if (root == null)
		    return;

		System.out.print(root.data + ", ");

		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private void storeBSTNodes(Node root, Vector<Node> nodes) {

		if(root == null) {
			return;
		}
		// Store nodes in Inorder (which is sorted
		// order for BST)
		storeBSTNodes(root.left, nodes);
		nodes.add(root);
		storeBSTNodes(root.right, nodes);
	} 

	private Node convertToBalancedBSTUtil(Vector<Node> nodes, int start, int end) {

		if(start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		Node node = nodes.get(mid);

		node.left = convertToBalancedBSTUtil(nodes, start, mid - 1);
		node.right = convertToBalancedBSTUtil(nodes, mid + 1, end);

		return node;
	}

	private Node convertToBalancedBST(Node root) {

		// Store nodes of given BST in sorted order
		Vector<Node> nodes = new Vector<Node>();
		storeBSTNodes(root, nodes);

		// Constucts BST from nodes[]
		int n = nodes.size();
		return convertToBalancedBSTUtil(nodes, 0, n - 1);
	}

	public static void main(String args[]) {

		// A Left-Skewed Binary Tree
		Node root = new Node(10);
		root.left = new Node(8);
		root.left.left = new Node(7);
		root.left.left.left = new Node(6);
		root.left.left.left.left = new Node(5);

		BinaryTree obj = new BinaryTree();

		root = obj.convertToBalancedBST(root);
		obj.printPreOrder(root);
	}
}
