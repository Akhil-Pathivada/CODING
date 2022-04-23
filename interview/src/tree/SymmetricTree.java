/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class SymmetricTree {
        
        private boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {
                if (root1 == null && root2 == null) {
                        return true;
                }
                if (root1 == null || root2 == null) {
                        return false;
                }
                if (root1.data != root2.data) {
                        return false;
                }
                return isSymmetricUtil(root1.left, root2.right)
                        && isSymmetricUtil(root1.right, root2.left);
        }
        
        private boolean isSymmetric(TreeNode root) {
                return isSymmetricUtil(root.left, root.right);
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(4);
                root.right = new TreeNode(2);
                root.right.left = new TreeNode(4);
                root.right.right = new TreeNode(3);
                System.out.println(new SymmetricTree().isSymmetric(root));
        }
}
