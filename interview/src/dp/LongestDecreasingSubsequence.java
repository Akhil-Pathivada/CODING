/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-decreasing-subsequence/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp;

public class LongestDecreasingSubsequence {
        
        private static int LDS(int[] nums, int n) {
                // store longest decreasing sequence till that point
                int[] lds = new int[n];
                lds[0] = 1;
                
                for(int i = 1; i < n; ++i) {
                        
                        lds[i] = 1;
                        // iterate over previous elements and check adding current element
                        // to its sequence can increase result
                        for(int j = 0; j < i; ++j) {
                                
                                if(nums[i] < nums[j] && lds[j] + 1 > lds[i]) {
                                        lds[i] = lds[j] + 1;
                                }
                        }
                }
                // get the maximum from lis[]
                int maxLength = Integer.MIN_VALUE;
                for(int i : lds) {
                        if(i > maxLength) {
                                maxLength = i;
                        }
                }
                return maxLength;
        }
        
        public static void main(String[] args) {
                
                int[] nums = { 15, 27, 14, 38, 63, 55, 46, 65, 85 };
                System.out.printf("Length of LDS is = %d ", LDS(nums, nums.length));
        }
}
