/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 * */

package array;

import java.util.Arrays;
import java.util.List;

public class CountSmallerOnRightSide {
        // BST Node
        static class TreeNode {
                
                TreeNode left, right;
                int data, count, dup = 1;
                public TreeNode(int d, int c) {
                        data = d;
                        count = c;
                }
        }
        
        private static TreeNode insertNode(int element, TreeNode root, Integer[] result, int i, int prevSum) {
                // base case
                if(root == null) {
                        root = new TreeNode(element, 0);
                        result[i] = prevSum;
                }
                // duplicate element found
                else if(element == root.data) {
                     root.dup++;
                     result[i] = prevSum + root.count;
                }
                // element is greater than current
                else if(element > root.data) {
                        root.right = insertNode(element, root.right, result, i, prevSum + root.count + root.dup);
                }
                // element is smaller than current
                else {
                        root.count++;
                        root.left = insertNode(element, root.left, result, i, prevSum);
                }
                return root;
        }
        
        private static List<Integer> countSmaller(int[] arr) {
                
                int n = arr.length;
                // store result
                Integer[] result = new Integer[n];
                TreeNode root = null;
                // iterate from back
                for(int i = n - 1; i >= 0; --i) {
                        root = insertNode(arr[i], root, result, i, 0);
                }
                return Arrays.asList(result);
        }
        
        public static void main(String[] args) {
                
                int[] arr = { 5, 2, 6, 1};
                System.out.println(countSmaller(arr));
        }
}
