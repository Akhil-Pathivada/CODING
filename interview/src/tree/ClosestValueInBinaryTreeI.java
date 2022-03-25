/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 */
package tree;

public class ClosestValueInBinaryTreeI {
        // tracks the min difference and closest value
        static double minDiff;
        static int closestValue;
        
        private static void findClosestValueUtil(TreeNode root, double target) {
                // base case
                if(root == null) {
                        return;
                }
                // If target itself is present
                if(root.data == target) {
                        closestValue = root.data;
                }
                // update min_diff and closest_value by checking current node value
                else if(Math.abs(target - root.data) < minDiff) {
                        minDiff = Math.abs(target - root.data);
                        closestValue = root.data;
                }
                /** if target is less than root data then move in
                left subtree else in right subtree */
                if(root.data > target) {
                        findClosestValueUtil(root.left, target);
                }
                else {
                        findClosestValueUtil(root.right, target);
                }
        }
        
        private static int findClosestValue(TreeNode root, double target) {
                // initialize values
                minDiff =  Double.MAX_VALUE;
                closestValue = -1;
                
                findClosestValueUtil(root, target);
                return closestValue;
        }
        
        public static void main(String[] args) {
                
                TreeNode node = new TreeNode(9);
                node.left = new TreeNode(4);
                node.right = new TreeNode(17);
                node.left.left = new TreeNode(3);
                node.left.right = new TreeNode(6);
                node.left.right.left = new TreeNode(5);
                node.left.right.right = new TreeNode(7);
                node.right.right = new TreeNode(22);
                node.right.right.left = new TreeNode(20);
                
                System.out.println("Closest value of is = " + findClosestValue(node, 18.99));
        }
}
