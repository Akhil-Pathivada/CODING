/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST extends TreeNode {
        
        private static TreeNode sortedArrayToBST(List<TreeNode> sortedArray, int start, int end) {
                // base case
                if(start > end) {
                        return null;
                }
                // get mid element and make as root
                int mid = (start + end) / 2;
                TreeNode root = sortedArray.get(mid);
                // recur for left and right subtrees
                root.left = sortedArrayToBST(sortedArray, start, mid - 1);
                root.right = sortedArrayToBST(sortedArray, mid + 1, end);
                return root;
        }
        
        private static void inOrderTraverse(TreeNode root, List<TreeNode> sortedArray) {
                // base case
                if(root == null) {
                        return;
                }
                inOrderTraverse(root.left, sortedArray);
                // insert element into list
                sortedArray.add(root);
                inOrderTraverse(root.right, sortedArray);
        }
        
        private static TreeNode balanceBinaryTreeToBST(TreeNode root) {
                
                List<TreeNode> sortedArray = new ArrayList<TreeNode>();
                // get the tree as a sorted array
                inOrderTraverse(root, sortedArray);
                // convert sorted array to BST
                return sortedArrayToBST(sortedArray, 0 , sortedArray.size() - 1);
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(8);
                root.left.left = new TreeNode(7);
                root.left.left.left = new TreeNode(6);
                root.left.left.left.left = new TreeNode(5);
        
                new BalanceBST().preOrder(balanceBinaryTreeToBST(root));
        }
}
