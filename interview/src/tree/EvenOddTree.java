/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/even-odd-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
        
        private boolean isEvenOdd(TreeNode root) {
                // base case
                if (root == null) {
                        return true;
                }
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                boolean level = false; // tracks even or odd level : false means even, true means odd
                int prev = 0;
                while (!queue.isEmpty()) {
                        int n = queue.size();
                        for (int i = 0; i < n; ++i) {
                                TreeNode node = queue.poll();
                                // for even level
                                if (!level && ((node.data % 2 == 0) || (i > 0 && prev >= node.data))) {
                                        return false;
                                }
                                // for odd level
                                if (level && ((node.data % 2 != 0) || (i > 0 && prev <= node.data))) {
                                        return false;
                                }
                                prev = node.data;
                                if (node.left != null) {
                                        queue.offer(node.left);
                                }
                                if (node.right != null) {
                                        queue.offer(node.right);
                                }
                        }
                        level = !level;
                }
                return true;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(10);
                root.left.left = new TreeNode(3);
                root.left.left.left = new TreeNode(12);
                root.left.left.right = new TreeNode(8);
                root.right = new TreeNode(4);
                root.right.left = new TreeNode(7);
                root.right.right = new TreeNode(9);
                root.right.left.left = new TreeNode(6);
                root.right.right.right = new TreeNode(2);
                System.out.println(new EvenOddTree().isEvenOdd(root));
        }
}
