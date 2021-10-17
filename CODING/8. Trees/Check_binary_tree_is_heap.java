/*
Given a binary tree, we need to check it has heap property or not, Binary tree need to fulfill the following two conditions for being a heap –
   1.It should be a complete tree (i.e. all levels except last should be full).
   2.Every node’s value should be greater than or equal to its child node (considering max-heap).
Time Complexity : O(n)
Space Complexity : O(n)
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

	private static boolean isHeapUtil(Node root) {

		if(root.left == null && root.right == null) {
			return true;
		}

		if(root.right == null) {
			return root.data >= root.left.data;
		}

		return ((root.data >= root.left.data) && (root.data >= root.right.data)) ? (isHeapUtil(root.left) && isHeapUtil(root.right)) : false;
	}

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

	private static boolean isHeap(Node root) {

		return isCompleteBT(root) && isHeapUtil(root);
	}

	public static void main(String args[]) {

		Node root = new Node(10);
		root.left = new Node(9);
		root.right = new Node(8);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(1);

        	System.out.println(isHeap(root) ? "YES" : "NO");
	}
}
