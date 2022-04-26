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

public class CheckBinaryTreeIsCompleteI {
        
        private boolean isCompleteBinaryTree(TreeNode root) {
                // base case
                if (root == null) {
                        return true;
                }
                Queue<TreeNode> queue = new LinkedList<TreeNode>();
                queue.add(root);
                /** Create a flag variable which will be set true
                when a non full node is seen */
                boolean nonFullNodeEncountered = false;
                // do the level order traversal
                while (!queue.isEmpty()) {
                        // poll the front
                        TreeNode node = queue.poll();
                        // insert left child
                        if (node.left != null) {
                                /** If we have seen a non full node, and we see a node
                                 with non-empty left child, then the given tree is not
                                 a complete Binary Tree */
                                if (nonFullNodeEncountered) {
                                        return false;
                                }
                                queue.add(node.left);
                        } else {
                                nonFullNodeEncountered = true;
                        }
                        // insert right child
                        if (node.right != null) {
                                /** If we have seen a non full node, and we see a node
                                 with non-empty left child, then the given tree is not
                                 a complete Binary Tree */
                                if (nonFullNodeEncountered) {
                                        return false;
                                }
                                queue.add(node.right);
                        } else {
                                nonFullNodeEncountered = true;
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
                System.out.println(new CheckBinaryTreeIsCompleteI().isCompleteBinaryTree(root) ? "Complete Binary Tree" : "Not a Complete Binary Tree");
        }
}
