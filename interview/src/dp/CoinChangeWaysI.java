/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 *
 */
package dp;

public class CoinChangeWaysI {
        
        private int coinChange(int[] coins, int n, int amount) {
                // If amount is 0 then there is 1 solution
                if (amount == 0) {
                      return 1;
                }
                // If amount <  0 then no solution exists
                if (amount < 0) {
                        return 0;
                }
                // If there are no coins and amount
                // is greater than 0, then no solution exist
                if (n <= 0 && amount >= 1) {
                        return 0;
                }
                return coinChange(coins, n , amount - coins[n - 1])
                        + coinChange(coins, n - 1, amount);
        }
        
        public static void main(String[] args) {
                int[] coins = { 1, 2, 3 };
                int amount = 4;
                System.out.println("Number of ways we can change = " + new CoinChangeWaysI().coinChange(coins, coins.length, amount));
        }
}
