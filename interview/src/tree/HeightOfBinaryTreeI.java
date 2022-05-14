/**
 * Height of a Binary Tree
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 * */
package tree;

public class HeightOfBinaryTreeI {
        // finding max depth of binary tree
        private int heightOfBinaryTree(TreeNode root) {
                // base case
                if (root == null) {
                        return 0;
                }
                // recur over left and right subtrees
                int leftTreeDepth = heightOfBinaryTree(root.left);
                int rightTreeDepth = heightOfBinaryTree(root.right);
                return Math.max(leftTreeDepth, rightTreeDepth) + 1;
        }
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.left.right = new TreeNode(5);
                System.out.println("Height of Binary Tree = " + new HeightOfBinaryTreeI().heightOfBinaryTree(root));
        }
}