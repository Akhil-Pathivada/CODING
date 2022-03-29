/**
 * Date 29/03/2022
 *
 * @author akhilpathivada
 *
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package tree;

public class LargestBSTInBinaryTreeI {
        // return size of binary tree
        private static int sizeofBinaryTree(TreeNode root) {
                
                return (root != null) ? 1 + sizeofBinaryTree(root.left) + sizeofBinaryTree(root.right) : 0;
        }
        // maximum in left subtree
        private static int maxInLeftSubTree(TreeNode root) {
                
                while(root != null && root.right != null) {
                        root = root.right;
                }
                return root.data;
        }
        // min in right subtree
        private static int minInRightSubTree(TreeNode root) {
                
                while(root != null && root.left != null) {
                        root = root.left;
                }
                return root.data;
        }
        // check given subtree is BST
        private static boolean isBST(TreeNode root) {
                
                if(root == null) {
                        return true;
                }
                if(root.left != null && maxInLeftSubTree(root.left) > root.data) {
                        return false;
                }
                if(root.right != null && minInRightSubTree(root.right) < root.data) {
                        return false;
                }
                return true;
        }
        // return size of largest BST
        private static int largestBST(TreeNode root) {
                
                if(root == null) {
                        return 0;
                }
                if(isBST(root)) {
                        return sizeofBinaryTree(root);
                }
                return Math.max(largestBST(root.left), largestBST(root.right));
        }
        
        public static void main(String[] args) {
        
                TreeNode root = new TreeNode(50);
                root.left = new TreeNode(10);
                root.right = new TreeNode(60);
                root.left.left = new TreeNode(5);
                root.left.right = new TreeNode(20);
                root.right.left = new TreeNode(55);
                root.right.left.left = new TreeNode(45);
                root.right.right = new TreeNode(70);
                root.right.right.left = new TreeNode(65);
                root.right.right.right = new TreeNode(80);
        
                System.out.printf("Size of largest BST is = %d ", largestBST(root));
        }
}
