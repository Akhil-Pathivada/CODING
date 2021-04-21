/* 
 * Given a binary tree consisting of N nodes,
 * the task is to replace each node in the binary tree with the sum of its preorder predecessor and preorder successor.
 *
 * Time Complexity: O(N)
 * Space Compexity: O(N)
 *  */


import java.util.*;

class Node {
	int data;
	Node left, right;

	Node(int data)
	{
		this.data = data;

		left = right = null;
	}
}

class BinaryTree { 

	static int index = 1;

	private void replaceNodesWithSum(Node root, Vector<Integer> V) {

		if(root == null) {
			return;
		}
		
		root.data = V.get(index - 1) + V.get(index + 1);
		++index;
		
		replaceNodesWithSum(root.left, V);
		replaceNodesWithSum(root.right, V);
	}

	private void storePreOrderNodes(Node root, Vector<Integer> V) {
		
		if(root == null) {
			return;
		}

		V.add(root.data);

		storePreOrderNodes(root.left, V);
		storePreOrderNodes(root.right, V);
	}

	private void printPreOrder(Node root) {

		if(root == null) {
			return;
		}
		System.out.print(root.data + ", ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	public static void main(String args[]) {

		Node root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.right = new Node(5);
		root.right.left = new Node(7);
		root.right.right = new Node(8);	

		BinaryTree obj = new BinaryTree();

		Vector<Integer> V = new Vector<Integer>();
		
		V.add(0);
		obj.storePreOrderNodes(root, V);
		System.out.println("Initial Nodes : ");
		V.add(0);

		obj.printPreOrder(root);

		obj.replaceNodesWithSum(root, V);

		System.out.println("Result Nodes : ");
		obj.printPreOrder(root);
	}

}

