/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 * Time Complexity : O(N * W)
 * Space Complexity : O(N * W)
 */
package dp;

public class ZeroOneKnapsackProblemII {
        
        private int fillKnapsack(int[] val, int[] wt, int W, int n) {
                // base case
                if (W == 0 || n == 0) {
                        return 0;
                }
                // row : denotes weight to be filled with
                // column : denotes weight to be filled (available weight)
                int[][] table = new int[n + 1][W + 1];
                for (int i = 0; i <= n; ++i) {
                        for (int j = 0; j <= W; ++j) {
                                if (i == 0 || j == 0) { // if weight is 0 or weight to be filled is 0
                                        table[i][j] = 0;
                                } else if (wt[i - 1] > j) { // if weight to be filled with is greater than available weight
                                        table[i][j] = table[i - 1][j];
                                } else {
                                        table[i][j] = Math.max(val[i - 1] + table[i - 1][j - wt[i - 1]], table[i - 1][j]);
                                }
                        }
                }
                return table[n][W];
        }
        
        public static void main(String[] args) {
                int val[] = new int[] { 60, 100, 120 };
                int wt[] = new int[] { 10, 20, 30 };
                int W = 50;
                int n = val.length;
                System.out.println("Maximum profit = " + new ZeroOneKnapsackProblemII().fillKnapsack(val, wt, W, n));
        }
}
