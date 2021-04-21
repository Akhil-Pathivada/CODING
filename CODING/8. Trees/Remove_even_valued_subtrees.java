/* 
 * Given a Binary Tree, the task is to remove all the subtrees that do not contain any odd valued node.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
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

	private void printPreOrder(Node root) {

		if(root == null) {
			return;
		}
		System.out.print(root.data + ", ");

		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private Node pruneTree(Node root) {

		if(root == null) {
			return null;
		}

		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);

		if(root.data % 2 == 0 && root.left == null && root.right == null) {
			return null;
		}
		return root;
	}

	public static void main(String args[]) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(10);
		root.right.right = new Node(5);
		root.right.left = new Node(12);

		BinaryTree obj = new BinaryTree();

		System.out.print("Initial Tree: " );
		obj.printPreOrder(root);

		Node newRoot = obj.pruneTree(root);

		System.out.print("Resulted Tree: " );
		obj.printPreOrder(newRoot);
	}
}
