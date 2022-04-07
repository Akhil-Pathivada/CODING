/**
 * Date 07/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class CheckChildrenSumPropertyInBinaryTree {
        
        private static boolean isSumProperty(TreeNode root) {
                // if root is NULL or it's a leaf node then return true
                if(root == null || (root.left == null && root.right == null)) {
                        return true;
                }
                int leftChildData = 0, rightChildData = 0;
                // if left child is not present then 0 is used as data of left child
                if(root.left != null) {
                        leftChildData = root.left.data;
                }
                // if right child is not present then 0 is used as data of right child
                if(root.right != null) {
                        rightChildData = root.right.data;
                }
                // if the node doesn't satisfy the property
                if(root.data != leftChildData + rightChildData) {
                        return false;
                }
                return isSumProperty(root.left) && isSumProperty(root.right);
        }
        
        
        public static void main(String[] args) {
        
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(8);
                root.right = new TreeNode(2);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(5);
                root.right.right = new TreeNode(2);
        
                System.out.println(isSumProperty(root));
        }
}
