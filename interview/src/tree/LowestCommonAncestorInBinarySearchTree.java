/**
 * Find the Least Common Ancestor of two struct nodes in a Binary Search Tree....
 *
 * Time complexity : O(N) (iterative & recursion)
 * Space complexity : O(H) -> recursive calls
 * Space complexity : O(1) -> iterative version
 * */
package tree;

public class LowestCommonAncestorInBinarySearchTree {
        
        private TreeNode getRecursiveLCA(TreeNode root, TreeNode n1, TreeNode n2) {
                // base case
                if (root == null) {
                        return null;
                }
                if (root.data > n1.data && root.data > n2.data) { // If both n1 and n2 are smaller than root, then LCA lies in left
                        return getRecursiveLCA(root.left, n1, n2);
                } else if(root.data < n1.data && root.data < n2.data) { // If both n1 and n2 are greater than root, then LCA lies in right
                        return getRecursiveLCA(root.right, n1, n2);
                }
                return root;
        }
        
        private TreeNode getIterativeLCA(TreeNode root, TreeNode n1, TreeNode n2) {
                while (root != null) {
                        if (root.data > n1.data && root.data > n2.data) { // If both n1 and n2 are smaller than root, then LCA lies in left
                                root = root.left;
                        } else if(root.data < n1.data && root.data < n2.data) { // If both n1 and n2 are greater than root, then LCA lies in right
                                root = root.right;
                        } else {
                                break;
                        }
                }
                return root;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(20);
                root.left = new TreeNode(8);
                root.right = new TreeNode(22);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(12);
                root.left.right.left = new TreeNode(10);
                root.left.right.right = new TreeNode(14);
                TreeNode n1 = root.left.right.left;
                TreeNode n2 = root.left.right.right;
                System.out.println("LCA of 10 && 14 is = " + new LowestCommonAncestorInBinarySearchTree().getIterativeLCA(root, n1, n2).data);
                System.out.println("LCA of 10 && 14 is = " + new LowestCommonAncestorInBinarySearchTree().getRecursiveLCA(root, n1, n2).data);
        }
}
