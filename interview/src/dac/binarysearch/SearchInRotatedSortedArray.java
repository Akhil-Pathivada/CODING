/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package dac.binarysearch;

public class SearchInRotatedSortedArray {
        private int searchElement(int[] nums, int target) {
                int n = nums.length;
                // base cases
                if (n == 0) {
                        return -1;
                }
                int left = 0, right = n - 1;
                // find the pivot index : that is the place where rotation happened
                // elements before and after pivot point are sorted.
                // target will be in one of the sorted arrays
                while (left < right) {
                        int midpoint = left + (right - left) / 2;
                        if (nums[midpoint] >= nums[right]) {
                                left = midpoint + 1;
                        } else {
                                right = midpoint;
                        }
                }
                // left is the pivot index
                int start = left;
                right = n - 1; left = 0;
                // check in which sorted array our target exists
                if (target >= nums[start] && target <= nums[right]) {
                        left = start;
                } else {
                        right = start;
                }
                // binary search on the sorted array
                while (left <= right) {
                        int mid = (left + right) / 2;
                        // target found
                        if (nums[mid] == target) {
                                return mid;
                        } else if(nums[mid] < target) {
                                left = mid + 1;
                        } else {
                                right = mid - 1;
                        }
                }
                return -1;
        }
        public static void main(String[] args) {
                int nums[] = { 4, 5, 6, 7, 0, 1, 2}, target = 1;
                System.out.printf("Target : %d is found at index : %d ", target, new SearchInRotatedSortedArray().searchElement(nums, target));
        
        }
}
