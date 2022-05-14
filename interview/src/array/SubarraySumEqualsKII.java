/**
 * Date 31/03/2022
 *
 * @author akhilpathivada
 *
 * Given an unsorted array of integers, find a continous subarray which adds to a given number.
 *
 * (works only for array with non-negative integers)
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class SubarraySumEqualsKII {
        private void subarraySum(int[] nums, int k) {
                int n = nums.length, left = 0, sum = nums[0];
                for (int right = 1; right < n; ++right) {
                        sum += nums[right];
                        // if subarray sum exceeded k : start a new subarray
                        while (sum > k && left < right) {
                                sum -= nums[left++];
                        }
                        // found
                        if (sum == k) {
                                System.out.printf("Sum found between indices %d and %d ", left, right);
                        }
                }
        }
        public static void main(String[] args) {
                int nums[] = { 1, 5, 20, 3, 10, 4}, k = 33;
                new SubarraySumEqualsKII().subarraySum(nums, k);
        }
}
