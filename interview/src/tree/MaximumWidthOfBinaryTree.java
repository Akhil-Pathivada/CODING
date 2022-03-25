/**
 * Given the root of a binary tree, return the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
 *
 *  https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
        
        private int getMaxWidthOfBinaryTree(TreeNode root) {
                // assign to smallest value
                int maxWidth = Integer.MIN_VALUE;
                /** Queue contains pairs, where each pair contains node and its position
                 for a node at position i, left child is at (2*i + 1) and right child is at (2*i + 2) position */
                Queue<Pair<TreeNode, Integer>> queue =  new LinkedList<>();
                // assuming root is at position 0
                queue.offer(new Pair<>(root, 0));
                // do level order traversal
                while(!queue.isEmpty()) {
                        // get first node of the current level
                        Pair<TreeNode, Integer> head = queue.peek();
                        // no. of elements in current level is equal to size of the queue
                        int currLevelSize = queue.size();
                        Pair<TreeNode, Integer> element = null;
                        // iterate over all elements in current level
                        while(currLevelSize-- > 0) {
                                // Dequeue
                                element = queue.remove();
                                TreeNode node = element.getKey();
                                // put left and right children and their positions into queue
                                if(node.left != null) {
                                        queue.offer(new Pair<>(node.left, 2 * element.getValue() + 1));
                                }
                                if(node.right != null) {
                                        queue.offer(new Pair<>(node.right, 2 * element.getValue() + 2));
                                }
                        }
                        maxWidth = Math.max(maxWidth, element.getValue() - head.getValue() + 1);
                }
                return maxWidth;
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.right = new TreeNode(7);
                root.right.right.right = new TreeNode(8);
                
                System.out.println("Max. Width of Binary Tree = " + new MaximumWidthOfBinaryTree().getMaxWidthOfBinaryTree(root));
        }
}
