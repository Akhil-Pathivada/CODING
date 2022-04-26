/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

public class MergeTwoBinaryTreesWhileCovering extends TreeNode {
        
        private static TreeNode mergeTwoBinaryTrees(TreeNode t1, TreeNode t2) {
                // base case
                if (t1 == null) {
                        return t2;
                }
                if (t2 == null) {
                        return t1;
                }
                t1.data += t2.data;
                t1.left = mergeTwoBinaryTrees(t1.left, t2.left);
                t1.right = mergeTwoBinaryTrees(t1.right, t2.right);
        
                return t1;
        }
        
        public static void main(String[] args) {
                
                TreeNode t1 = new TreeNode(1);
                t1.left = new TreeNode(3);
                t1.left.left = new TreeNode(5);
                t1.right = new TreeNode(2);
        
                TreeNode t2 = new TreeNode(2);
                t2.left = new TreeNode(1);
                t2.left.right = new TreeNode(4);
                t2.right = new TreeNode(3);
                t2.right.right = new TreeNode(7);
                
                t1.preOrder(mergeTwoBinaryTrees(t1, t2));
        }
}
