/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package slidingwindow;

public class MinimumSizeSubarraySum {
        
        private static int minSubArrayLength(int[] nums, int target) {
                
                if(nums == null || nums.length == 0) {
                        return 0;
                }
                int minLength = Integer.MAX_VALUE, start = 0, sum = 0;
                for(int i = 0; i < nums.length; ++i) {
                        sum += nums[i];
                        // slide the window
                        while(sum >= target) {
                                
                                minLength = Math.min(minLength, i - start + 1);
                                sum -= nums[start++];
                        }
                }
                return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
        }
        
        public static void main(String[] args) {
                
                int nums[] = { 2, 3, 1, 2, 4, 3}, target = 7;
                System.out.println(minSubArrayLength(nums, target));
        }
}
