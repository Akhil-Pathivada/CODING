/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package tree;

public class ClosestValueInBinaryTreeII {
        
        private static int findClosestValue(TreeNode root, double target) {
                // initialize values
                double minDiff =  Double.MAX_VALUE;
                int closestValue = -1;
                
                while(root != null) {
                        // compute current difference
                        double currentDiff = Math.abs(target - root.data);
                        // if current difference less then min difference so far
                        if(currentDiff < minDiff) {
                                minDiff = currentDiff;
                                closestValue = root.data;
                        }
                        // check in left subtree
                        if(target < root.data) {
                                root = root.left;
                        }
                        // check in right subtree
                        else if(target > root.data) {
                                root = root.right;
                        }
                        // if node equals to target
                        else {
                                break;
                        }
                }
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
