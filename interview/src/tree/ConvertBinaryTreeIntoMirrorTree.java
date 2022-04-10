/**
 * Date 10/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class ConvertBinaryTreeIntoMirrorTree {
        
        private static TreeNode mirror(TreeNode root) {
                // base case
                if(root == null) {
                        return null;
                }
                // recur to get mirror of left and right subtrees
                TreeNode left = mirror(root.left);
                TreeNode right = mirror(root.right);
                // swap the left and right pointers
                root.left = right;
                root.right = left;
                return root;
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                
                root.inOrder(mirror(root));
        }
}
