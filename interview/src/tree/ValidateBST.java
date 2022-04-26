/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

public class ValidateBST {
        
        private TreeNode prev = null;
        private boolean isValidBST(TreeNode root) {
                // base case
                if (root == null) {
                        return true;
                }
                // do inorder traversal
                if (!isValidBST(root.left)) {
                        return false;
                }
                if (prev != null && root.data < prev.data) {
                        return false;
                }
                prev = root;
                return isValidBST(root.right);
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(20);
                root.left = new TreeNode(8);
                root.right = new TreeNode(22);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(12);
                root.left.right.left = new TreeNode(10);
                root.left.right.right = new TreeNode(14);
                System.out.println(new ValidateBST().isValidBST(root));
        }
}
