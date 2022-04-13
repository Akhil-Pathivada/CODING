/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp;

public class MaximumSumIncreasingSubsequence {
        
        private static int MSIS(int[] arr, int n) {
                int msis[] = new int[n];
                msis[0] = arr[0];
                // Compute maximum sum values in bottom up manner
                for(int i = 1; i < n; ++i) {
                        msis[i] = arr[i];
                        for(int j = 0; j < i; ++j) {
                                
                                if(arr[i] > arr[j] && msis[j] + arr[i] > msis[i]) {
                                        msis[i] = msis[j] + arr[i];
                                }
                        }
                }
                int maxSum = msis[0];
                // Pick maximum of all msis values
                for(int i = 1; i < n; ++i) {
                        if(msis[i] > maxSum) {
                                maxSum = msis[i];
                        }
                }
                return maxSum;
        }
        
        public static void main(String[] args) {
                int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
                System.out.println("Sum of maximum sum increasing subsequence is = " + MSIS(arr, arr.length));
        }
}
