/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(log(N))
 * */
package tree;

public class SortedArrayToBST extends TreeNode {
        
        private TreeNode sortedArrayToBSTUtil(int[] nums, int start, int end) {
                // base case
                if (start > end) {
                        return null;
                }
                // get mid element and make as root
                int mid = (start + end) / 2;
                TreeNode root = new TreeNode(nums[mid]);
                // recur for left and right subtrees
                root.left = sortedArrayToBSTUtil(nums, start, mid - 1);
                root.right = sortedArrayToBSTUtil(nums, mid + 1, end);
                return root;
        }
        
        private TreeNode sortedArrayToBST(int[] nums) {
                // base case
                if (nums.length == 0) {
                        return null;
                }
                return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
        }
        
        public static void main(String[] args) {
                int nums[] = {-10, -3, 0, 5, 9};
                SortedArrayToBST obj = new SortedArrayToBST();
                obj.preOrder(obj.sortedArrayToBST(nums));
        }
}
