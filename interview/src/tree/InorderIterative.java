/**
 * Date 26/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
        
        private List<Integer> inorder(TreeNode root) {
                // base case
                if (root == null) {
                        return new ArrayList<>();
                }
                List<Integer> result = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();
                TreeNode current = root;
                while (current != null || !stack.isEmpty()) {
                        while (current != null) {
                                stack.push(current);
                                current = current.left;
                        }
                        current = stack.pop();
                        result.add(current.data);
                        current = current.right;
                }
                return result;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                System.out.println(new InorderIterative().inorder(root));
        }
}
