/**
 * Date 31/03/2022
 *
 * @author akhilpathivada
 *
 * Given an unsorted array of integers, find a continous subarray which adds to a given number.
 *
 * (works only for array with non-negative integers)
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package array;

public class SubarraySumEqualsKI {
        private void subarraySum(int[] nums, int k) {
                int n = nums.length;
                for (int i = 0; i < n; ++i) {
                        int sum = 0;
                        for (int j = i; j < n; ++j) {
                                sum += nums[j];
                                // if subarray sum exceeded k : start a new subarray
                                if (sum > k) {
                                        break;
                                }
                                // found
                                if (sum == k) {
                                        System.out.printf("Sum found between indices %d and %d ", i, j);
                                }
                        }
                }
        }
        public static void main(String[] args) {
                int nums[] = { 1, 5, 20, 3, 10, 4}, k = 33;
                new SubarraySumEqualsKI().subarraySum(nums, k);
        }
}
