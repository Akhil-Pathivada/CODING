/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 */
package greedy;

public class CoinChangeProblem {
        
        private int minCoins(int[] currency, int n) {
                if (n == 0) {
                        return 0;
                }
                int coins = 0;
                for (int i = currency.length - 1; i >= 0; --i) {
                        while (n >= currency[i]) {
                                n -= currency[i];
                                ++coins;
                        }
                }
                return coins;
        }
        
        public static void main(String[] args) {
                int[] currency = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
                int n = 93;
                System.out.println(new CoinChangeProblem().minCoins(currency, n));
        }
}
