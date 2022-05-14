/**
 * Date 26/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class BestTimeToBuyAndSellStock {
        private int maxProfit(int[] prices) {
                if (prices.length == 0) {
                        return 0;
                }
                int minSoFar = prices[0], max = 0;
                for (int i = 1; i < prices.length; ++i) {
                        if (prices[i] > minSoFar) {
                                max = Math.max(max, prices[i] - minSoFar);
                        } else {
                                minSoFar = prices[i];
                        }
                }
                return max;
        }
        public static void main(String[] args) {
                int[] prices = { 7, 1, 5, 3, 6, 4 };
                System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
        }
}
