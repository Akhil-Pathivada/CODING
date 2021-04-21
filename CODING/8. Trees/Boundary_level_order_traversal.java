/* 
 * Given a Binary Tree, the task is to print all levels of this tree in Boundary Level order traversal.
 *
 * Boundary Level order traversal: In this traversal, the first element of the level (starting boundary)
 * is printed first, followed by last element (ending boundary).
 * Then the process is repeated for the second and last-second element, till the complete level has been printed.
 *
 * Time Complexity: O()
 * Space Complexity: O()
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

	private void printLevelInStartEndFashion(deque<Node> deque) {
		
		int size = deque.size();

		while(size--) {
			
			System.out.print(deque.pop());
			System.out.print(deque.);

		}
	}

	private void printBoundaryLevelOrder(Node root) {

		Deque<Node> deque = new LinkedList<Node>();
		deque.add(root);

		while(!deque.isEmpty()) {

			Node node = deque.front();

			printLevelInStartEndFashion(deque);

			if(node.left != null) {

				deque.push(node.left);
			}
			if(node.right != null) {

				deque.push(node.right);
			}
		}
	}

	public static void main(String args[]) {

		BinaryTree obj = new BinaryTree();
		
		obj.printBoundaryLevelOrder(root);
	}
}
