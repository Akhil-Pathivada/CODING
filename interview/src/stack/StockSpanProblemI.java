/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package stack;

import java.util.Arrays;

public class StockSpanProblemI {
        private void calculateSpan(int[] price, int[] stock, int n) {
                for(int i = 0; i < n; ++i) {
                        int j = i - 1;
                        for( ; j >= 0 && price[j] <= price[i]; --j);
                        stock[i] = i - j - 1;
                }
        }
        public static void main(String[] args) {
                int price[] = {100, 80, 60, 70, 60, 75, 85};
                int n = price.length;
                int stock[] = new int[n];
                new StockSpanProblemI().calculateSpan(price, stock, n);
                System.out.println(Arrays.toString(stock));
        }
}
