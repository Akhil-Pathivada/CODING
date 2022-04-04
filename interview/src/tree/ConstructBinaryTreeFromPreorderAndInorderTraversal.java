/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 *
 */
package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
        
        private static TreeNode constructTreeUtil(int preOrderStart, int inOrderStart, int inOrderEnd, int[] preorder, int[] inorder) {
                // base case
                if(preOrderStart > preorder.length - 1 || inOrderStart > inOrderEnd) {
                        return null;
                }
                // create the root
                TreeNode root = new TreeNode(preorder[preOrderStart]);
                // search the index of current root in inorder
                int inOrderIndex = 0;
                for(int i = inOrderStart; i <= inOrderEnd; ++i) {
                        // root found in inorder
                        if(inorder[i] == root.data) {
                                inOrderIndex = i;
                                break;
                        }
                }
                // recur to create left and right subtrees
                root.left = constructTreeUtil(preOrderStart + 1, inOrderStart, inOrderIndex - 1, preorder, inorder);
                root.right = constructTreeUtil(preOrderStart + inOrderIndex - inOrderStart + 1, inOrderIndex + 1, inOrderEnd, preorder, inorder);
                
                return root;
        }
        
        private static TreeNode constructTree(int[] preorder, int[] inorder) {
                
                return constructTreeUtil(0, 0, inorder.length - 1, preorder, inorder);
        }
        
        public static void main(String[] args) {
        
                int[] preorder = { 3, 9, 20, 15, 7}, inorder = { 9, 3, 15, 20, 7};
                TreeNode root = constructTree(preorder, inorder);
                
                root.preOrder(root);
        }
}
