/**
 * You are given the root of a binary tree.
 * We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras {
        
        int cams = 0;
        
        private void DFS(TreeNode root, TreeNode parent, Set<TreeNode> covered) {
                // base case
                if(root == null) {
                        return;
                }
                // recur over left and right subtrees
                DFS(root.left, root, covered);
                DFS(root.right, root, covered);
                /** Check if we need to add camera at node.
                 Parent is null & node is uncovered
                 OR
                 if any of its left or right child are not covered */
                if(parent == null && !covered.contains(root) || !covered.contains(root.left) || !covered.contains(root.right)) {
                        ++cams;
                        /** since cam is attached to node,
                         itself, parent, children are also covered,
                         so mark them as covered */
                        covered.add(root);
                        covered.add(parent);
                        covered.add(root.left);
                        covered.add(root.right);
                }
        }
        
        private int minCameraCover(TreeNode root) {
                // base case
                if(root == null) {
                        return 0;
                }
                // tracks the nodes which were covered by camera
                Set<TreeNode> covered = new HashSet<>();
                // Skip the leaf nodes and start from one level above
                covered.add(null);
                // since parent of root is null, we send it as null
                DFS(root, null, covered);
                return cams;
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.left.left = new TreeNode(7);
        
                System.out.println("minimum number of cameras needed to monitor all nodes of the tree = " + new BinaryTreeCameras().minCameraCover(root));
        }
}
