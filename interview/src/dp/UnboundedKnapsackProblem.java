/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 *
 * Time Complexity : O(N * W)
 * Space Complexity : O(W)
 */
package dp;

public class UnboundedKnapsackProblem {
        
        private int fillKnapsack(int[] val, int[] wt, int W, int n) {
                // dp[i] is going to store maximum value
                // with knapsack capacity i
                int[] dp = new int[W + 1];
                for (int i = 0; i <= W; ++i) {
                        for (int j = 0; j < n; ++j) {
                                if (wt[j] <= i) {
                                        dp[i] = Math.max(dp[i], val[j] + dp[i - wt[j]]);
                                }
                        }
                }
                return dp[W];
        }
        
        public static void main(String[] args) {
                int W = 100;
                int val[] = {10, 30, 20};
                int wt[] = {5, 10, 15};
                int n = val.length;
                System.out.println(new UnboundedKnapsackProblem().fillKnapsack(val, wt, W, n));
        }
}
