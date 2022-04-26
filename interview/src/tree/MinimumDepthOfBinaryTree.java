/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Time Complexity : O()
 * Space Complexity : O()
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
        
        private int minDepth(TreeNode root) {
                // base case
                if (root == null) {
                        return 0;
                }
                int minDepth = 0;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                        // update depth
                        ++minDepth;
                        int nodeCount = queue.size();
                        // iterate over all nodes of a level
                        while (nodeCount-- > 0) {
                                TreeNode current = queue.poll();
                                // a leaf node found, so this node ends the min depth
                                if (current.left == null && current.right == null) {
                                        return minDepth;
                                }
                                // insert left and right children to queue
                                if (current.left != null) {
                                        queue.add(current.left);
                                }
                                if (current.right != null) {
                                        queue.add(current.right);
                                }
                        }
                }
                return minDepth;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.left.right = new TreeNode(5);
                System.out.println("Min Depth of Binary Tree = " + new MinimumDepthOfBinaryTree().minDepth(root));
        }
}
