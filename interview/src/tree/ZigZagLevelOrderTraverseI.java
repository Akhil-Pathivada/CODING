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

import java.util.*;

public class ZigZagLevelOrderTraverseI {
        
        private List<List<Integer>> zigZagLevelOrder(TreeNode root) {
                // base case
                if (root == null) {
                        return new ArrayList<>();
                }
                // store result
                List<List<Integer>> resultList = new ArrayList<>();
                // maintain two stacks: stacks will store alternate level nodes
                Stack<TreeNode> stack1 = new Stack<>();
                Stack<TreeNode> stack2 = new Stack<>();
                // push root
                stack1.push(root);
                while (!stack1.isEmpty() || !stack2.isEmpty()) {
                        TreeNode node;
                        // list to store result nodes at each level
                        List<Integer> list = new ArrayList<>();
                        // iterate till first stack is empty
                        while (!stack1.isEmpty()) {
                                node = stack1.pop();
                                list.add(node.data);
                                // add left and right children
                                if (node.left != null) {
                                        stack2.push(node.left);
                                }
                                if (node.right != null) {
                                        stack2.push(node.right);
                                }
                        }
                        resultList.add(list);
                        // store next level result nodes
                        list = new ArrayList<>();
                        // iterate till second stack is empty
                        while (!stack2.isEmpty()) {
                                node = stack2.pop();
                                list.add(node.data);
                                // add right and left children
                                if (node.right != null) {
                                        stack1.push(node.right);
                                }
                                if (node.left != null) {
                                        stack1.push(node.left);
                                }
                        }
                        // avoid adding empty list to result
                        if (!list.isEmpty()) {
                                resultList.add(list);
                        }
                }
                return resultList;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(4);
                root.left = new TreeNode(2);
                root.right = new TreeNode(7);
                root.left.left = new TreeNode(1);
                root.left.right = new TreeNode(3);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(9);
                System.out.println(new ZigZagLevelOrderTraverseI().zigZagLevelOrder(root));
        }
}
