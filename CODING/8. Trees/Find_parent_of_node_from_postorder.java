/* Given two integers N and K where N denotes the height of a binary tree, the task is to find the parent of the node with value K in a binary tree whose postorder traversal is first 
 *
 * 2^{N}-1
 *
 * natural numbers
 *
 * (1, 2, ... 2^{N}-1)
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
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

	private int findParent(int height, int targetNode) {
		
		int start = 1;
		int end = (int)Math.pow(2, height) - 1;

		// if the target node is root
		if(end == targetNode) {

			return -1;
		}
		while(targetNode >= -1) {

			end = end - 1;

			int mid = start + (end - start) / 2;

			if(mid ==  targetNode || end == targetNode) {
				
				return end + 1;
			}
			else if(targetNode < mid) {

				end = mid;
			}
			else {

				start = mid;
			}
		}
		return -1;
	}

	public static void main(String args[]) {

		int height = 4;
		int targetNode = 6;
		
		BinaryTree obj = new BinaryTree();

		System.out.println("Parent: " + obj.findParent(height, targetNode));
	}
}
