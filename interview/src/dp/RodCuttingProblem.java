/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 */
package dp;

public class RodCuttingProblem {
        
        private int cutRod(int[] prices, int n) {
                if (n == 0) {
                        return 0;
                }
                int[][] table = new int[n + 1][n + 1];
                // row : denotes of how much length we want to cut(profit assigned to it)
                // column : denotes for what of length of rod we want to cut
                for (int i = 0; i <= n; ++i) {
                        for (int j = 0; j <= n; ++j) {
                                if (i == 0 || j == 0) { // if length of rod is 0, or we want to cut into length of 0
                                        table[i][j] = 0;
                                } else if (i > j) {
                                        table[i][j] = table[i - 1][j];
                                } else {
                                        table[i][j] = Math.max(table[i - 1][j], table[i][j - i] + prices[i - 1]);
                                }
                        }
                }
                return table[n][n];
        }
        
        public static void main(String[] args) {
                int[] prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
                int n = prices.length;
                System.out.println("Maximum obtained value is = " + new RodCuttingProblem().cutRod(prices, n));
        }
}
