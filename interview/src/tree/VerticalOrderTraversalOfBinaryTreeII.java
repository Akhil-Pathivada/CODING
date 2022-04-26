/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderTraversalOfBinaryTreeII {
        
        private void getVerticalOrder(TreeNode root, int hd, TreeMap<Integer, Vector<Integer>> map) {
                // base case
                if (root == null) {
                        return;
                }
                Vector<Integer> nodes = map.get(hd);
                // if there is no entry for this hd
                if (nodes == null) {
                        nodes = new Vector<>();
                }
                // add root data into list
                nodes.add(root.data);
                // insert back the <k, v>
                map.put(hd, nodes);
                // Recur for left and right subtrees
                getVerticalOrder(root.left, hd - 1, map);
                getVerticalOrder(root.right, hd + 1, map);
        }
        
        private void printVerticalOrder(TreeNode root) {
                // stores horizontal distance and nodes having that distance
                TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
                int hd = 0; // horizontal distance
                getVerticalOrder(root, hd, map);
                // printing the values of TreeMap
                for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
                        System.out.println(entry.getValue());
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(7);
                root.right.left.right = new TreeNode(8);
                root.right.right.right = new TreeNode(9);
                new VerticalOrderTraversalOfBinaryTreeII().printVerticalOrder(root);
        }
}