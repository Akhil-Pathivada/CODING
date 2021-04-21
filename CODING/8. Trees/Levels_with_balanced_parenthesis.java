/* 
 * Given a Binary Tree consisting only ‘(‘ and ‘)’ a level is considered to be balanced if the nodes of the level having parenthesis are balanced from left to right.
 * The task is to count the total number of balanced levels in a binary tree
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

	private int checkParenthesisBalanced(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		// count of balanced levels
		int count = 0;
		
		while(!queue.isEmpty()) { 
			
			// stack to check balancing of parenthesis
			Stack<Character> stack = new Stack<>();

			boolean isBalanced = true;
			// size of that level
			int length = queue.size();

			while(length > 0) {
				
				Node temp = queue.remove();

				if(temp.data == '(') {

					stack.push('(');
				}
				else {
					if(stack.size() > 0 && stack.peek() == '(') { 
						stack.pop();
					}
					else {
						isBalanced = false;
					}	
				}
				if(temp.left != null) {

					queue.add(temp.left);
				}
				if(temp.right != null) {

					queue.add(temp.right);
				}
				--length;
			}
			if(isBalanced && stack.size() == 0) {
				
				++count;
			} 
		}
		return count;
	}

	public static void main(String args[]) {

		Node root = new Node('(');
		root.left = new Node('(');
		root.right = new Node(')');
		root.left.left = new Node('(');
		root.left.right = new Node(')');
		root.right.right = new Node('(');
	   	root.left.left.left = new Node('(');
		root.left.left.right = new Node('(');
		root.right.right.left = new Node(')');
		root.right.right.right = new Node(')');

		BinaryTree obj = new BinaryTree();
		System.out.println("Levels with Balanced Parenthesis: " + obj.checkParenthesisBalanced(root));
	}
}
