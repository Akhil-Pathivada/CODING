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

public class MaximumSumSubarrayIII {
        
        private static void maxSubArraySum(int[] arr) {
                
                int n = arr.length, maxSumSoFar, currSum;
                maxSumSoFar = currSum = arr[0];
                
                for(int i = 0; i < n; ++i) {
                        
                        currSum = Math.max(currSum + arr[i], arr[i]);
                        maxSumSoFar = Math.max(currSum, maxSumSoFar);
                }
                System.out.printf(" Maximum sum in a contiguous Subarray is : %d ", maxSumSoFar);
        }
        
        public static void main(String[] args) {
                
                int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3};
                maxSubArraySum(arr);
        }
}
