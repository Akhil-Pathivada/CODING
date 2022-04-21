/**
 * Date 10/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class IdenticalBinaryTrees {
        
        private boolean isIdentical(TreeNode root1, TreeNode root2) {
                // base case
                if(root1 == null && root2 == null) {
                        return true;
                }
                if(root1 != null && root2 != null) {
                        return (root1.data == root2.data) &&
                                isIdentical(root1.left, root2.left) &&
                                isIdentical(root1.right, root2.right);
                }
                return false;
        }
        
        public static void main(String[] args) {
                TreeNode root1 = new TreeNode(1);
                root1.left = new TreeNode(2);
                root1.right = new TreeNode(3);
                root1.left.left = new TreeNode(4);
                root1.left.right = new TreeNode(5);
                TreeNode root2 = new TreeNode(1);
                root2.left = new TreeNode(2);
                root2.right = new TreeNode(3);
                root2.left.left = new TreeNode(4);
                root2.left.right = new TreeNode(5);
                System.out.println(new IdenticalBinaryTrees().isIdentical(root1, root2));
        }
}
