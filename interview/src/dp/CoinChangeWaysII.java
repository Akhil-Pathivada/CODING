/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 *
 * Time Complexity: O(m * n)
 * Space Complexity : O(n)
 *
 */
package dp;

public class CoinChangeWaysII {
        
        private int coinChange(int[] coins, int n, int amount) {
                // table[i] will be storing the number of solutions for
                // value i. We need n+1 rows as the table is constructed
                // in bottom up manner using the base case (n = 0)
                int[] table = new int[amount + 1];
                // Base case (If given value is 0)
                table[0] = 1;
                // Pick all coins one by one and update the table[] values
                // after the index greater than or equal to the value of the picked coin
                for (int i = 0; i < n; ++i) {
                        for (int j = coins[i]; j <= amount; ++j) {
                                table[j] += table[j - coins[i]];
                        }
                }
                return table[n];
        }
        
        public static void main(String[] args) {
                int[] coins = { 1, 2, 3 };
                int amount = 4;
                System.out.println("Number of ways we can change = " + new CoinChangeWaysII().coinChange(coins, coins.length, amount));
        }
}
