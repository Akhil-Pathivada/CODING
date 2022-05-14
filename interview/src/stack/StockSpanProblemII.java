/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblemII {
        private void calculateSpan(int[] price, int[] stock, int n) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < n; ++i) {
                        while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                                stack.pop();
                        }
                        stock[i] = stack.isEmpty() ? i : (i - stack.peek() - 1);
                        stack.push(i);
                }
        }
        public static void main(String[] args) {
                int price[] = {100, 80, 60, 70, 60, 75, 85};
                int n = price.length;
                int stock[] = new int[n];
                new StockSpanProblemII().calculateSpan(price, stock, n);
                System.out.println(Arrays.toString(stock));
        }
}
