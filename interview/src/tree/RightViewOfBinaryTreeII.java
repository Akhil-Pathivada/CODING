/**
 *  Print the right view of a Binary Tree
 *  Time Complexity : O(N)
 *  Space Complexity : O(N) -> Queue
 * */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTreeII {
        
        private void printRightView(TreeNode root, int level) {
                // base case
                if (root == null) {
                        return;
                }
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                        int n = queue.size();
                        for (int i = 1; i <= n; ++i) {
                                TreeNode node = queue.poll();
                                // print the first node of the current level
                                if (i == 1) {
                                        System.out.printf(" %d,", node.data);
                                }
                                // insert its right and left children
                                if (node.right != null) {
                                        queue.add(node.right);
                                }
                                if (node.left != null) {
                                        queue.add(node.left);
                                }
                        }
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(7);
                root.left.right = new TreeNode(8);
                root.right.right = new TreeNode(15);
                root.right.left = new TreeNode(12);
                root.right.right.left = new TreeNode(14);
                new RightViewOfBinaryTreeII().printRightView(root, 1);
        }
}
