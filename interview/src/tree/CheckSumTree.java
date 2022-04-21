/**
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

public class CheckSumTree {
        
        private int checkSumTree(TreeNode root) {
                // base case
                if(root == null) {
                        return 0;
                }
                // if leaf
                if(root.left == null && root.right == null) {
                        return root.data;
                }
                // capture sum of left and right tree
                int leftTreeSum = checkSumTree(root.left);
                int rightTreeSum = checkSumTree(root.right);
                // if current subtree is sum tree
                if(leftTreeSum != -1 && rightTreeSum != -1 && (leftTreeSum + rightTreeSum == root.data)) {
                        return 2 * root.data;
                }
                return -1;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(26);
                root.left = new TreeNode(10);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(6);
                root.right.right=new TreeNode(3);
                System.out.println(new CheckSumTree().checkSumTree(root) != -1 ? "YES" : " NO");
        }
}
