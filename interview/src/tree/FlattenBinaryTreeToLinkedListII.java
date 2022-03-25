/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(H) -> Height of Tree
 * */
package tree;

public class FlattenBinaryTreeToLinkedListII {
        
        private TreeNode prev = null;
        
        private void flatten(TreeNode root) {
                // base case
                if(root == null) {
                        return;
                }
                // recursively convert right and left subtrees
                flatten(root.right);
                flatten(root.left);
                // since we are making as linkedlist, make left as null
                root.left = null;
                // attach root right pointer to already visited prev node
                root.right = prev;
                prev = root;
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
                
                new FlattenBinaryTreeToLinkedListII().flatten(root);
                
                System.out.print("Flattend List : ");
                for( ; root != null; root = root.right) {
                        System.out.print(root.data + ", ");
                }
        }
}
