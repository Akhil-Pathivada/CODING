/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 *
 */
package tree;

import java.util.Stack;

public class KthSmallestElementInBST {
        
        private int kthSmallest(TreeNode root, int k) {
                int count = 0;
                Stack<TreeNode> stack = new Stack<>();
                TreeNode current = root;
                while (current != null || !stack.isEmpty()) {
                        if (current != null) {
                                stack.push(current);
                                current = current.left;
                        } else {
                                TreeNode node = stack.pop();
                                if (++count == k) {
                                        return node.data;
                                }
                                current = node.right;
                        }
                }
                return -1;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(5);
                root.left = new TreeNode(3);
                root.left.left = new TreeNode(2);
                root.left.left.left = new TreeNode(1);
                root.left.right = new TreeNode(4);
                root.right = new TreeNode(6);
                int k = 3;
                System.out.println(new KthSmallestElementInBST().kthSmallest(root, 3));
        }
}
