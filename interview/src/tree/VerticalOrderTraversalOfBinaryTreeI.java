/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(H) -> Height of Tree
 */
package tree;

public class VerticalOrderTraversalOfBinaryTreeI {
        // store min and max horizontal distances of tree
        static int MIN = 0, MAX = 0;
        // find min and max distances with respect to root
        private void findMinMaxHorizontalDistance(TreeNode root, int hd) {
                // base case
                if (root == null) {
                        return;
                }
                // update min and max
                if (hd < MIN) {
                        MIN = hd;
                }
                if (hd > MAX) {
                        MAX = hd;
                }
                // Recur for left and right subtrees
                findMinMaxHorizontalDistance(root.left, hd - 1);
                findMinMaxHorizontalDistance(root.right, hd + 1);
        }
        
        private void printNodesOfHorizontalDistance(TreeNode root, int line_no, int hd) {
                // base case
                if (root == null) {
                        return;
                }
                // If this node is on the given line number
                if (hd == line_no) {
                        System.out.print(root.data + " ");
                }
                // Recur for left and right subtrees
                printNodesOfHorizontalDistance(root.left, line_no, hd - 1);
                printNodesOfHorizontalDistance(root.right, line_no, hd + 1);
        }
        
        private void printVerticalOrder(TreeNode root) {
                // compute horizontal distance of tree
                findMinMaxHorizontalDistance(root, 0);
                // Iterate through all possible vertical lines starting
                // from the leftmost line and print nodes line by line
                for (int line_no = MIN; line_no <= MAX; ++line_no) {
                        printNodesOfHorizontalDistance(root, line_no, 0);
                        System.out.println();
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(7);
                root.right.left.right = new TreeNode(8);
                root.right.right.right = new TreeNode(9);
                new VerticalOrderTraversalOfBinaryTreeI().printVerticalOrder(root);
        }
}