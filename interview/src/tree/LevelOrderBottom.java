/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
        
        private List<List<Integer>> levelOrderBottom(TreeNode root) {
                List<List<Integer>> result = new ArrayList<List<Integer>>();
                if (root == null) {
                        return result;
                }
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                        List<Integer> list = new ArrayList<>();
                        int n = queue.size();
                        while (n-- > 0) {
                                TreeNode node = queue.poll();
                                list.add(node.data);
                                if (node.left != null) {
                                        queue.offer(node.left);
                                }
                                if (node.right != null) {
                                        queue.offer(node.right);
                                }
                        }
                        result.add(0, list);
                }
                return result;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(3);
                root.left = new TreeNode(9);
                root.right = new TreeNode(20);
                root.right.left = new TreeNode(15);
                root.right.right = new TreeNode(7);
                System.out.println(new LevelOrderBottom().levelOrderBottom(root));
        }
}
