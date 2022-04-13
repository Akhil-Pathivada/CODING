/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp;

public class LongestBitonicSubsequence {
        
        private static int LBS(int[] nums, int n) {
                // store longest increasing sequence till that point
                int lis[] = new int[n];
                // store longest decreasing sequence till that point
                int[] lds = new int[n];
                // compute LIS
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
                // compute LDS
                lds[n - 1] = 1;
                for(int i = n - 2; i >= 0; --i) {
                        lds[i] = 1;
                        // iterate over next elements and check adding current element
                        // to its sequence can increase result
                        for(int j = n - 1; j > i; --j) {
                                if(nums[i] > nums[j] && lds[j] + 1 > lds[i]) {
                                        lds[i] = lds[j] + 1;
                                }
                        }
                }
                // compute and get the maximum by using both lis[] and lds[]
                int maxLength = lis[0] + lds[0] - 1;
                for(int i = 1; i < n; ++i) {
                        if(lis[i] + lds[i] - 1 > maxLength) {
                                maxLength = lis[i] + lds[i] - 1;
                        }
                }
                return maxLength;
        }
        
        public static void main(String[] args) {
                int[] nums = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
                System.out.printf("Length of LBS is = %d ", LBS(nums, nums.length));
        }
}
