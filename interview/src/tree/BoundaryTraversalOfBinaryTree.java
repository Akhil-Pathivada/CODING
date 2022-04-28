/**
 * Date 28/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalOfBinaryTree {
        
        private List<Integer> result;
        // print the leaves
        private void printLeaves(TreeNode root) {
                if (root == null) {
                        return;
                }
                if (root.left == null && root.right == null) {
                        result.add(root.data);
                }
                printLeaves(root.left);
                printLeaves(root.right);
        }
        // print the right most nodes
        private void printBoundaryRight(TreeNode root) {
                if (root == null) {
                        return;
                }
                if (root.right != null) {
                        printBoundaryRight(root.right);
                        result.add(root.data);
                } else if (root.left != null) {
                        printBoundaryRight(root.left);
                        result.add(root.data);
                }
        }
        // print left most nodes
        private void printBoundaryLeft(TreeNode root) {
                if (root == null) {
                        return;
                }
                if (root.left != null) {
                        result.add(root.data);
                        printBoundaryLeft(root.left);
                } else if (root.right != null) {
                        result.add(root.data);
                        printBoundaryLeft(root.right);
                }
        }
        
        private void boundaryOrder(TreeNode root) {
                if (root == null) {
                        return;
                }
                result = new ArrayList<>();
                result.add(root.data);
                printBoundaryLeft(root.left);
                printLeaves(root);
                printBoundaryRight(root.right);
                System.out.println(result);
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(20);
                root.left = new TreeNode(8);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(12);
                root.left.right.left = new TreeNode(10);
                root.left.right.right = new TreeNode(14);
                root.right = new TreeNode(22);
                root.right.right = new TreeNode(25);
                new BoundaryTraversalOfBinaryTree().boundaryOrder(root);
        }
}
