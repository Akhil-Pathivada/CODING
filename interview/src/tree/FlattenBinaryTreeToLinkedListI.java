/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(H) -> Height of Tree
 * */
package tree;

public class FlattenBinaryTreeToLinkedListI {
        
        private void flatten(TreeNode root) {
                // base case
                if (root == null) {
                        return;
                }
                // store both child pointers into temp
                TreeNode tempLeft = root.left;
                TreeNode tempRight = root.right;
                /* since we are converting to linkedlist
                make left pointer of node as null */
                root.left = null;
                // recursively convert left and right subtrees
                flatten(tempLeft);
                flatten(tempRight);
                // point the right pointer to left child
                root.right = tempLeft;
                TreeNode current = root;
                while (current.right != null) {
                        current = current.right;
                }
                current.right = tempRight;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(4);
                root.right = new TreeNode(5);
                root.right = new TreeNode(6);
                System.out.print("Original Tree : ");
                root.preOrder(root);
                new FlattenBinaryTreeToLinkedListI().flatten(root);
                System.out.print("Flattend List : ");
                for( ; root != null; root = root.right) {
                        System.out.print(root.data + ", ");
                }
        }
}
