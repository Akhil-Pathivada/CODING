/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class MaximumSumSubarrayIV {
        private void maxSubArraySum(int[] arr) {
                int n = arr.length, maxSumSoFar, currSum, start, end;
                maxSumSoFar = currSum = arr[0];
                start = end = -1;
                for (int i = 0; i < n; ++i) {
                        currSum = Math.max(currSum + arr[i], arr[i]);
                        // update the maxSumSoFar and end index
                        if (currSum > maxSumSoFar) {
                                maxSumSoFar = currSum;
                                end = i;
                        }
                }
                start = end;
                // compute the start index
                for (int sum = 0; sum != maxSumSoFar; --start) {
                        sum += arr[start];
                }
                System.out.printf("Maximum sum in a contiguous Subarray is : %d, found between indexes %d and %d", maxSumSoFar, start + 1, end);
        }
        public static void main(String[] args) {
                int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3};
                new MaximumSumSubarrayIV().maxSubArraySum(arr);
        }
}
