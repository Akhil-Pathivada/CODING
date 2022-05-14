/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity : O(N ^ 3)
 * Space Complexity : O(1)
 */
package array;

public class MaximumSumSubarrayI {
        private void maxSubArraySum(int[] arr) {
                int n = arr.length, maxSum = Integer.MIN_VALUE;
                int start = -1, end = -1;
                for (int i = 0; i < n; ++i) {
                        // find out all subarrays
                        for (int j = i + 1; j < n; ++j) {
                                int sum = 0;
                                // find sum in all subarrays
                                for (int k = i; k <= j; ++k) {
                                        sum += arr[k];
                                }
                                // update max sum
                                if (sum > maxSum) {
                                        maxSum = sum;
                                        start = i;
                                        end = j;
                                }
                        }
                }
                System.out.printf(" Maximum sum in a contiguous Subarray is : %d, found between indexes %d and %d", maxSum, start, end);
        }
        public static void main(String[] args) {
                int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3};
                new MaximumSumSubarrayI().maxSubArraySum(arr);
        }
}
