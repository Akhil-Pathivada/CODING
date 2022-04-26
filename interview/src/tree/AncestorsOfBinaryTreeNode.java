/**
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

public class AncestorsOfBinaryTreeNode {
        
        private boolean printAncestors(TreeNode root, int target) {
                // base case
                if (root == null) {
                        return false;
                }
                // if target found
                if (root.data == target) {
                        return true;
                }
                // if target exists in left or right subtree, current node becomes an ancestor
                if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
                        // print ancestor
                        System.out.println(root.data);
                        return true;
                }
                return false;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.left.left.left = new TreeNode(7);
                int target = 7;
                System.out.println(new AncestorsOfBinaryTreeNode().printAncestors(root, target) ? "" : "Target not found");
        }
}
