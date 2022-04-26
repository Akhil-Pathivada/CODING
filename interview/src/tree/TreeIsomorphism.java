/**
 * Write a function to detect if two trees are isomorphic. Two trees are called isomorphic if one of them can be obtained from
 * other by a series of flips, i.e. by swapping left and right children of a number of nodes. Any number of nodes at any level
 * can have their children swapped. Two empty trees are isomorphic.
 *
 * Time Complexity : O(min(m, n))
 * Space Complexity : O(min(m, n))
 * where m, n are sizes of two trees respectively
 * */
package tree;

public class TreeIsomorphism {
        
        private boolean areIsomorphicTrees(TreeNode n1, TreeNode n2) {
                // Both roots are NULL, trees isomorphic by definition
                if (n1 == null && n2 == null) {
                        return true;
                }
                // Exactly one of the n1 and n2 is NULL, trees not isomorphic
                if (n1 == null || n2 == null) {
                        return false;
                }
                if (n1.data != n2.data) {
                        return false;
                }
                 /** There are two possible cases for n1 and n2 to be isomorphic
                 Case 1: The subtrees rooted at these nodes have NOT been
                 "Flipped".
                 Both of these subtrees have to be isomorphic.
                 Case 2: The subtrees rooted at these nodes have been "Flipped" */
                return (areIsomorphicTrees(n1.left, n2.left) && areIsomorphicTrees(n1.right, n2.right)) ||
                        (areIsomorphicTrees(n1.left, n2.right) && areIsomorphicTrees(n1.right, n2.left));
        }
        
        public static void main(String[] args) {
                TreeNode root1 = new TreeNode(1);
                root1.left = new TreeNode(2);
                root1.right = new TreeNode(3);
                root1.left.left = new TreeNode(4);
                root1.left.right = new TreeNode(5);
                root1.right.left = new TreeNode(6);
                root1.left.right.left = new TreeNode(7);
                root1.left.right.right = new TreeNode(8);
                TreeNode root2 = new TreeNode(1);
                root2.left = new TreeNode(3);
                root2.right = new TreeNode(2);
                root2.right.left = new TreeNode(4);
                root2.right.right = new TreeNode(5);
                root2.left.right = new TreeNode(6);
                root2.right.right.left = new TreeNode(8);
                root2.right.right.right = new TreeNode(7);
                System.out.println(new TreeIsomorphism().areIsomorphicTrees(root1, root2) ? "YES" : "NO");
        }
}
