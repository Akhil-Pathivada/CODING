/**
 * Date 28/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * 
 */
package tree;

public class MaximumPathSumInBinaryTree {
        
        private static int MAX_PATH_SUM = Integer.MIN_VALUE;
        private int findMaxSum(TreeNode root) {
                // base case
                if (root == null) {
                        return 0;
                }
                // store maximum path sum going through left and
                // right child of root respectively
                int maxSumInLeftSubTree = findMaxSum(root.left);
                int maxSumInRightSubTree = findMaxSum(root.right);
                // Max path for parent call of root
                // This path must include at-most one child of root
                int maxSumIncludingLeftOrRightTree = Math.max(Math.max(maxSumInLeftSubTree, maxSumInRightSubTree) + root.data, root.data);
                // Max Top represents the sum when the Node under consideration is the root of the maxsum path and
                // no ancestors of root are there in max sum path
                int maxSumIncludingLeftAndRightTree = Math.max(maxSumIncludingLeftOrRightTree, maxSumInLeftSubTree + root.data + maxSumInRightSubTree);
                MAX_PATH_SUM = Math.max(MAX_PATH_SUM, maxSumIncludingLeftAndRightTree);
                return maxSumIncludingLeftOrRightTree;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(2);
                root.right = new TreeNode(10);
                root.left.left = new TreeNode(20);
                root.left.right = new TreeNode(1);
                root.right.right = new TreeNode(-25);
                root.right.right.left = new TreeNode(3);
                root.right.right.right = new TreeNode(4);
                new MaximumPathSumInBinaryTree().findMaxSum(root);
                System.out.println("maximum path sum is : " + MAX_PATH_SUM);
        }
}
