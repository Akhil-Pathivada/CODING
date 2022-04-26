/**
 * Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBinaryTreeIsCompleteII {
        
        private boolean isCompleteBinaryTree(TreeNode root) {
                // base case
                if (root == null) {
                        return true;
                }
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                /** Create a flag variable which will be set true
                 when a leaf node is seen */
                boolean leafEncountered = false;
                // do the level order traversal
                while (!queue.isEmpty()) {
                        // poll the front
                        TreeNode node = queue.poll();
                        // if we have seen leaf node
                        if (node == null) {
                                leafEncountered = true;
                        } else {
                                // if the leaf node we have seen eariler is not last node
                                if (leafEncountered) {
                                        return false;
                                }
                                // insert left and right children
                                queue.add(node.left);
                                queue.add(node.right);
                        }
                }
                return true;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                System.out.println(new CheckBinaryTreeIsCompleteII().isCompleteBinaryTree(root) ? "Complete Binary Tree" : "Not a Complete Binary Tree");
        }
}
