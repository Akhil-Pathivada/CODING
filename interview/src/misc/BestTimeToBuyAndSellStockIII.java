/**
 * Date 30/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package misc;

public class BestTimeToBuyAndSellStockIII {
        
        private int maxProfit(int[] prices) {
                int n = prices.length;
                if (n == 0) {
                        return 0;
                }
                // captures max profit we can get till this point
                int[] left = new int[n];
                // captures max profit we can get if we sell on this day in future
                int[] right = new int[n];
                // compute left array
                int min = prices[0];
                for (int i = 1; i < n; ++i) {
                        min = Math.min(min, prices[i]);
                        int profit = prices[i] - min;
                        left[i] = Math.max(left[i - 1], profit);
                }
                // compute right array
                int max = prices[n - 1];
                for (int i = n - 2; i >= 0; --i) {
                        max = Math.max(max, prices[i]);
                        int profit = max - prices[i];
                        right[i] = Math.max(right[i + 1], profit);
                }
                int maxPro = 0;
                for (int i = 0; i < n; ++i) {
                        maxPro = Math.max(maxPro, left[i] + right[i]);
                }
                return maxPro;
        }
        
        public static void main(String[] args) {
                int[] prices = { 7, 1, 5, 3, 6, 4 };
                System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
        }
}
