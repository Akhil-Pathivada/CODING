/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package array;

public class MaximumSumSubarrayII {
        private void maxSubArraySum(int[] arr) {
                int n = arr.length, maxSum = Integer.MIN_VALUE;
                int start = -1, end = -1;
                int sumArray[] = new int[n];
                // compute the cummulative sum at every element
                sumArray[0] = arr[0];
                for (int i = 1; i < n; ++i) {
                        sumArray[i] = sumArray[i - 1] + arr[i];
                }
                for (int i = 0; i < n; ++i) {
                        // update max sum
                        if(sumArray[i] > maxSum) {
                                maxSum = sumArray[i];
                                start = 0;
                                end = i;
                        }
                }
                for (int i = 1; i < n; ++i) {
                        int prevSum = sumArray[i - 1];
                        // find out all subarrays
                        for (int j = i; j < n; ++j) {
                                // sum of current subarray
                                int sum =  sumArray[j] - prevSum;
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
                new MaximumSumSubarrayII().maxSubArraySum(arr);
        }
}
