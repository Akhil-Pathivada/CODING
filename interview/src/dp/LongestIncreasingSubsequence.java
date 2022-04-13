/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp;

public class LongestIncreasingSubsequence {
        
        private static int LIS(int[] nums, int n) {
                // store longest increasing sequence till that point
                int lis[] = new int[n];
                lis[0] = 1;
                for(int i = 1; i < n; ++i) {
                        lis[i] = 1;
                        // iterate over previous elements and check adding current element
                        // to its sequence can increase result
                        for (int j = 0; j < i; ++j) {
                                if(nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                                        lis[i] = lis[j] + 1;
                                }
                        }
                }
                // get the maximum from lis[]
                int maxLength = Integer.MIN_VALUE;
                for(int i : lis) {
                        if(i > maxLength) {
                                maxLength = i;
                        }
                }
                return maxLength;
        }
        
        public static void main(String[] args) {
                
                int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60 };
                System.out.printf("Longest Increasing Subsequence : %d ", LIS(nums, nums.length));
        }
}
