/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package dac.binarysearch;

public class MinimumInRotatedSortedArray {
        private int findMinimum(int[] nums) {
                int n = nums.length;
                // base cases
                if (n == 0) {
                        return 0;
                }
                if (n == 1) {
                        return nums[0];
                }
                int left = 0, right = n - 1;
                // find the pivot index : that is the place where rotation happened
                // elements before and after pivot point are sorted.
                // min will be the next one of pivot
                while (left < right) {
                        int mid = (left + right) / 2;
                        if (nums[mid] >= nums[right]) {
                                left = mid + 1;
                        } else {
                                right = mid;
                        }
                }
                return nums[left % n];
        }
        public static void main(String[] args) {
                int nums[] = { 4, 5, 6, 7, 0, 1, 2};
                System.out.printf("Minimum in sorted rotated array = %d ", new MinimumInRotatedSortedArray().findMinimum(nums));
        }
}
