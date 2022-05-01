/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class RecoverBinarySearchTree {
        
        private TreeNode prev, first, middle, second;
        // This function does inorder traversal to find out the two swapped nodes.
        // It sets three pointers, first, middle and second. If the swapped nodes are
        // adjacent to each other, then first and middle contain the resultant nodes
        // Else, first and second contain the resultant nodes
        private void recoverTreeUtil(TreeNode root) {
                // base case
                if (root == null) {
                        return;
                }
                // Recur for the left subtree
                recoverTreeUtil(root.left);
                // If this node is smaller than the previous node, it's
                // violating the BST rule.
                if (prev != null && root.data < prev.data) {
                        // If this is first violation, mark these two nodes as
                        // 'first' and 'middle'
                        if (first == null) {
                                first = prev;
                                middle = root;
                        } else { // If this is second violation, mark this node as last
                                second = root;
                        }
                }
                // Mark this node as previous
                prev = root;
                // Recur for the right subtree
                recoverTreeUtil(root.right);
        }
        
        private void recoverTree(TreeNode root) {
                prev = first = middle = second = null;
                recoverTreeUtil(root);
                if (first != null && second != null) { // Fix (or correct) the tree
                        int temp = first.data;
                        first.data = second.data;
                        second.data = temp;
                } else if (second == null) { // Adjacent nodes swapped
                        int temp = first.data;
                        first.data = middle.data;
                        middle.data = temp;
                } else {
                        // nodes have not been swapped,
                        // passed tree is really BST.
                        System.out.println("No need of swapping.");
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(6);
                root.left = new TreeNode(10);
                root.right = new TreeNode(2);
                root.left.left = new TreeNode(1);
                root.left.right = new TreeNode(3);
                root.right.right = new TreeNode(12);
                root.right.left = new TreeNode(7);
                new RecoverBinarySearchTree().recoverTree(root);
                root.inOrder(root);
        }
}
