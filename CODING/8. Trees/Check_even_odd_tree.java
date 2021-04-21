/* 
 * Given a Binary Tree, the task is to check if the binary tree is an Even-Odd binary tree or not.
 *
 * A Binary Tree is called an Even-Odd Tree when all the nodes which are at even levels
 * have even values (assuming root to be at level 0) and all the nodes which are at odd levels have odd values.
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

	private boolean checkEvenOddTree(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		int level = -1;

		while(!queue.isEmpty()) { 
			
			// size of the current level
			++level;

			int size = queue.size();

			for(int i = 0; i < size; ++i) {

				Node node = queue.poll();

				if(level % 2 == 0) {
					if(node.data % 2 != 0) {
						return false;
					}
				}
				else {
					if(node.data % 2 != 1) {
						return false;
					}
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return true;
	}

	public static void main(String args[]) {

		Node root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(9);
		root.left.left = new Node(4);
		root.left.right = new Node(10);
		root.right.right = new Node(6);

		BinaryTree obj = new BinaryTree();

		System.out.println(obj.checkEvenOddTree(root) ? "Yes" : "No");
	}
}

