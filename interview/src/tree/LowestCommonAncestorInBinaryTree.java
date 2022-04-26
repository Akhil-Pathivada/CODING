/**
 * Find the Least Common Ancestor of two struct nodes in a Binary Tree
 *
 * Time complexity : O(N)
 * Space complexity : O(H) -> Height of Tree
 * */
package tree;

public class LowestCommonAncestorInBinaryTree {
        
        private TreeNode getLCA(TreeNode root, TreeNode n1, TreeNode n2) {
                //  base case
                if (root == null) {
                        return null;
                }
                // If either n1 or n2 matches with root's key, report
                //  the presence by returning root (Note that if a key is
                // ancestor of other, then the ancestor key becomes LCA
                if (root == n1 || root == n2) {
                        return root;
                }
                // Look for both nodes in left and right subtrees
                TreeNode left = getLCA(root.left, n1, n2);
                TreeNode right = getLCA(root.right, n1, n2);
                // If both of the above calls return Non-NULL, then one key
                // is present in one subtree and other is present in other,
                // So this node is the LCA
                if (left != null && right != null) {
                        return root;
                }
                // Otherwise check if left subtree or right subtree is LCA
                return left != null ? left : right;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(7);
                TreeNode n1 = root.left.right;
                TreeNode n2 = root.right;
                System.out.println("LCA of 5 && 3 is = " + new LowestCommonAncestorInBinaryTree().getLCA(root, n1, n2).data);
        }
}
