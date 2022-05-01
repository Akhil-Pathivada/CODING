/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 * Time Complexity : O(2 ^ N)
 * Space Complexity : O(N)
 */
package dp;

public class ZeroOneKnapsackProblemI {
        
        private int fillKnapsack(int[] val, int[] wt, int W, int n) {
                // base case
                if (W == 0 || n == 0) {
                        return 0;
                }
                if (wt[n - 1] > W) {
                        return fillKnapsack(val, wt, W, n - 1);
                }
                return Math.max(val[n - 1] + fillKnapsack(val, wt, W - wt[n - 1], n - 1),
                        fillKnapsack(val, wt, W, n - 1));
        }
        
        public static void main(String[] args) {
                int val[] = new int[] { 60, 100, 120 };
                int wt[] = new int[] { 10, 20, 30 };
                int W = 50;
                int n = val.length;
                System.out.println("Maximum profit = " + new ZeroOneKnapsackProblemI().fillKnapsack(val, wt, W, n));
        }
}
