/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/house-robber/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package dp;

public class HouseRobber {
        
        private static int rob(int[] nums, int n) {
                // base case
                if(n == 0) {
                        return 0;
                }
                if(n == 1) {
                        return nums[0];
                }
                if(n == 2) {
                        return Math.max(nums[0], nums[1]);
                }
                int[] dp = new int[n];
                dp[0] = nums[0];
                dp[1] = Math.max(nums[0], nums[1]);
                for(int i = 2; i < n; ++i) {
                        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
                }
                return dp[n - 1];
        }
        
        public static void main(String[] args) {
                int[] nums = { 2, 7, 9, 3, 1};
                System.out.println("Max amount you can rob = " + rob(nums, nums.length));
        }
}
