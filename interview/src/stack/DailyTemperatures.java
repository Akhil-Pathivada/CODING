/**
 * Date 28/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {
        
        private int[] dailyTemperatures(int[] temperatures) {
                int[] result = new int[temperatures.length];
                Stack<Integer> stack = new Stack<>();
                for (int i = temperatures.length - 1; i >= 0; --i) {
                        while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                                stack.pop();
                        }
                        result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                        stack.push(i);
                }
                return result;
        }
        
        public static void main(String[] args) {
                int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
                System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));
        }
}
