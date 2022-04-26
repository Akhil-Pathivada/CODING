/**
 * Date 26/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderIterative {
        
        private List<Integer> postorder(TreeNode root) {
                // base case
                if (root == null) {
                        return new ArrayList<>();
                }
                List<Integer> result = new ArrayList<>();
                Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
                s1.push(root);
                while (!s1.isEmpty()) {
                        TreeNode node = s1.pop();
                        s2.push(node);
                        if (node.left != null) {
                                s1.push(node.left);
                        }
                        if (node.right != null) {
                                s1.push(node.right);
                        }
                }
                while (!s2.isEmpty()) {
                        result.add(s2.pop().data);
                }
                return result;
        }
        
        public static void main(String[] args) {
                TreeNode root = null;
                root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(7);
                System.out.println(new PostorderIterative().postorder(root));
        }
}
