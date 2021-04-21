/*
Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). 
If the complete Binary Tree is BST, then return the size of whole tree.

Time Complexity : O(n)
Space Complexity : O(n)
*/

class Node { 

	/* A binary tree node has data,
	 * pointer to left child and a
	 * pointer to right child. */
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class BST {

	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;

	class NodeInfo {
		
		int size; // size of subtree
		int max; // max number in subtree
		int min; // min number in subtree
		int ans; // size of largest BST which is subtree of current node
		boolean isBST; // is this subtree is BST or not

		NodeInfo() {}

		NodeInfo(int size, int min, int max, int ans, boolean isBST) {
			
			this.size = size;
			this.min = min;
			this.max = max;
			this.ans = ans;
			this.isBST = true;
		}
	}

	private NodeInfo getSizeOfBST(Node root) {
		
		if(root == null) {
			return new NodeInfo(0, MIN, MAX, 0, true);
		}
		// Leaf node itself is a BST- with size 0
		if(root.left == null && root.right == null) {
			return new NodeInfo(1, root.data, root.data, 1, true);
		}
		// Recur on both Left and Right SubTrees
		NodeInfo leftSubTree = getSizeOfBST(root.left);
		NodeInfo rightSubTree = getSizeOfBST(root.right);
		// Returning the info of the Root node
		NodeInfo returnNodeInfo = new NodeInfo();
		// Computing size of the every node
		returnNodeInfo.size = 1 + leftSubTree.size + rightSubTree.size;
		
		// if both and Left and Right Subtrees are BST
		// then need computing nodeInfo of root
		if(leftSubTree.isBST && rightSubTree.isBST && leftSubTree.max < root.data && rightSubTree.min > root.data) {
		
			returnNodeInfo.min = Math.min(Math.min(leftSubTree.min, rightSubTree.min), root.data);
			returnNodeInfo.max = Math.max(Math.max(leftSubTree.max, rightSubTree.max), root.data);
			returnNodeInfo.ans = returnNodeInfo.size;
			returnNodeInfo.isBST = true;
			return returnNodeInfo;
		}
		returnNodeInfo.ans = Math.max(leftSubTree.ans, rightSubTree.ans);
		returnNodeInfo.isBST = false;
		return returnNodeInfo;
	}

	public static void main(String args[]) {

		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right = new Node(60);
		root.right.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);

		BST obj = new BST();
		System.out.println("Size of the Largest BST: " + obj.getSizeOfBST(root).ans);
	}
}
