/**
 * Date 12/04/2022
 *
 * @author akhilpathivada
 *
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package dp;

public class MinimumOperationsToReachNFrom0 {
        
        private static int minOperations(int n) {
                if(n == 0) {
                        return 0;
                }
                if(n == 1) {
                        return 1;
                }
                if(n == 2) {
                        return 2;
                }
                int[] dp = new int[n + 1];
                dp[0] = 0; dp[1] = 1; dp[2] = 2;
                for(int i = 3; i <= n; ++i) {
                        if(i % 2 == 0) {
                                dp[i] = Math.min(dp[i/2], dp[i - 1]) + 1;
                        }
                        else {
                                dp[i] = dp[i - 1] + 1;
                        }
                }
                return dp[n];
        }
        
        public static void main(String[] args) {
                int n = 8;
                System.out.printf("Min operations to reach %d is = %d ", n, minOperations(n));
        }
}
