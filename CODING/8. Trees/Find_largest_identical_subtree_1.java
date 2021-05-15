
/** 
  * Given a binary tree, find the largest subtree having identical left and right subtree. Expected complexity is O(n).
  *
  * For example,
  *
  * Input:
  *             50
  *          /      \
  *         10       60
  *        /  \     /   \
  *       5   20   70    70
  *                / \   / \
  *              65  80 65  80
  * Output:
  *  Largest subtree is rooted at node 60
  *
  * Time Complexity: O(N ^ 2) - O(N) takes to compare strings
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

	class Pair {

	    int size;
	    String string;

	    Pair(int a, String b) {
		size = a;
		string = b;
	    }
	}

	private static Node maxIdenticalTreeRoot = null;
	private static int maxIdenticalTreeSize = 0; 


	private Pair largestIdenticalSubTree(Node root, String str) {

		if(root == null) {
			return new Pair(0, str);
		}

		String left = "", right = "";

		Pair leftTree = largestIdenticalSubTree(root.left, left);
		int ls = leftTree.size;
	       	left = leftTree.string;
		
		Pair rightTree = largestIdenticalSubTree(root.right, right);
		int rs = rightTree.size;
		right = rightTree.string;

		int size = ls + rs + 1;

		if(left.equals(right)) {

			if(size > maxIdenticalTreeSize) {
				
				maxIdenticalTreeSize = size;
				maxIdenticalTreeRoot = root;
			}
		}
		// append left subtree data
		str += "|" + left + "|";

		// append current node data
		str += "|" + root.data + "|";

		// append right subtree data
		str += "|" + right + "|";

		return new Pair(size, str);
	}

	public static void main(String args[]) {

		Node root = new Node(50);
		root.left = new Node(10);
		root.right = new Node(60);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right.left = new Node(70);
		root.right.left.left = new Node(65);
		root.right.left.right = new Node(80);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);

		BinaryTree obj = new BinaryTree();

		obj.largestIdenticalSubTree(root, "");
		
		System.out.println("Largest Identical Subtree size: " + maxIdenticalTreeSize + " is rooted at: " + maxIdenticalTreeRoot.data);
	}
}
