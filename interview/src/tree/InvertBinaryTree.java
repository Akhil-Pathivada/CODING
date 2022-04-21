/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 * */

package tree;

public class InvertBinaryTree {
        
        private TreeNode invertBinaryTree(TreeNode root) {
                // base case
                if(root == null) {
                        return null;
                }
                // store left child into temp
                TreeNode tempLeft = root.left;
                // make left to point to right and vice versa
                root.left = invertBinaryTree(root.right);
                root.right = invertBinaryTree(tempLeft);
                return root;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(4);
                root.left = new TreeNode(2);
                root.right = new TreeNode(7);
                root.left.left = new TreeNode(1);
                root.left.right = new TreeNode(3);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(9);
                root.preOrder(new InvertBinaryTree().invertBinaryTree(root));
        }
}
