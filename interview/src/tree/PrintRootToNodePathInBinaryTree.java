/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * Given a node in binary tree, find the path to reach to it starting from root.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.Stack;

public class PrintRootToNodePathInBinaryTree {
        
        private Stack<Integer> stack;
        private boolean rootToNodePathUtil(TreeNode root, int target) {
                // base case
                if (root == null) {
                        return false;
                }
                // target found
                if (root.data == target) {
                        stack.push(root.data);
                        return true;
                }
                boolean findInLeftSubTree = rootToNodePathUtil(root.left, target);
                boolean findInRightSubTree = rootToNodePathUtil(root.right, target);
                // if target found in left or right subtree : add to result stack
                if (findInLeftSubTree || findInRightSubTree) {
                        stack.push(root.data);
                        return true;
                }
                return false;
        }
        
        private void rootToNodePath(TreeNode root, int target) {
                stack = new Stack<>();
                if (!rootToNodePathUtil(root, target)) {
                        System.out.println("Node not found in tree");
                        return;
                }
                while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + ", ");
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.left.right.left = new TreeNode(6);
                root.left.right.right = new TreeNode(7);
                root.right = new TreeNode(3);
                int target = 7;
                new PrintRootToNodePathInBinaryTree().rootToNodePath(root, target);
        }
}
