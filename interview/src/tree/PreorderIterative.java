/**
 * Date 26/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/iterative-preorder-traversal/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {
        
        private List<Integer> preorder(TreeNode root) {
                // base case
                if (root == null) {
                        return new ArrayList<>();
                }
                List<Integer> result = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                while (!stack.isEmpty()) {
                        // Pop the top item from stack and add to result
                        TreeNode node = stack.pop();
                        result.add(node.data);
                        // Push right and left children of the popped node to stack
                        if (node.right != null) {
                                stack.push(root.right);
                        }
                        if (node.left != null) {
                                stack.push(root.left);
                        }
                }
                return result;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(8);
                root.right = new TreeNode(2);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(2);
                System.out.println(new PreorderIterative().preorder(root));
        }
}
