/**
 * Date 07/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package tree;


public class DiameterOfBinaryTree {
        
        static int max = 0;
        
        private static int maxDepth(TreeNode root) {
                // base case
                if(root == null) {
                        return 0;
                }
                int depthOfLeftSubTree = maxDepth(root.left);
                int depthOfRightSubTree = maxDepth(root.right);
                // capture maximum depth of left or subtree + 1 and update max
                max = Math.max(max, depthOfLeftSubTree + depthOfRightSubTree);
                return 1 + Math.max(depthOfLeftSubTree, depthOfRightSubTree);
        }
        
        private static int diameterOfBinaryTree(TreeNode root) {
                
                maxDepth(root);
                return max;
        }
        
        public static void main(String[] args) {
        
                TreeNode root= new TreeNode(1);
                root.left = new TreeNode(2);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.left.right.right = new TreeNode(6);
                root.left.right.right.left = new TreeNode(7);
               
                System.out.printf("The diameter of given binary tree is : %d ", diameterOfBinaryTree(root));
        }
}
