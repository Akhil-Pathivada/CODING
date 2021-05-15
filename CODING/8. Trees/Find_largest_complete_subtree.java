/* 
 * Given a Binary Tree, the task is to find the size of largest Complete sub-tree in the given Binary Tree.
 * Complete Binary Tree – A Binary tree is Complete Binary Tree if all levels are completely
 * filled except possibly the last level and the last level has all keys as left as possible.
 *
 * Input:
 *          50
 *       /      \
 *    30         60
 *   /   \      /    \
 *  5    20   45      70
 *           /
 *          10
 * Output:
 * Size : 4
 * Inorder Traversal : 10 45 60 70
 *
 * Time Complexity: O()
 * Space Complexity: O()
 *  */

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
