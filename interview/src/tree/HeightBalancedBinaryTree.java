/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 * */
package tree;

public class HeightBalancedBinaryTree {
        
        private int depth(TreeNode root) {
                if (root == null) {
                        return 0;
                }
                return 1 + Math.max(depth(root.left), depth(root.right));
        }
        
        private boolean isBalanced(TreeNode root) {
                if (root == null) {
                        return true;
                }
                int leftTreeDepth = depth(root.left);
                int rightTreeDepth = depth(root.right);
                return (Math.abs(leftTreeDepth - rightTreeDepth) <= 1)
                        && isBalanced(root.left)
                        && isBalanced(root.right);
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.left.right = new TreeNode(5);
                System.out.println(new HeightBalancedBinaryTree().isBalanced(root));
        }
}
