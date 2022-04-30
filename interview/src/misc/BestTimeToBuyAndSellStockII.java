/**
 * Date 30/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package misc;

public class BestTimeToBuyAndSellStockII {
        
        private int maxProfit(int[] prices) {
                if (prices.length == 0) {
                        return 0;
                }
                int maxPro = 0;
                for (int i = 1; i < prices.length; ++i) {
                        if (prices[i] > prices[i - 1]) {
                                maxPro += prices[i] - prices[i - 1];
                        }
                }
                return maxPro;
        }
        
        public static void main(String[] args) {
                int[] prices = { 7, 1, 5, 3, 6, 4 };
                System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(prices));
        }
}
