/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
        
        private int largestRectangleArea(int[] heights, int n) {
                // Create an empty stack. The stack holds indexes of heights[] array
                // The bars stored in stack are always in increasing order of their heights.
                Stack<Integer> stack = new Stack<>();
                int top, area, maxArea = 0;
                // Run through all bars of given histogram
                int i = 0;
                while (i < n) {
                        // If this bar is higher than the bar on top stack, push it to stack
                        if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                                stack.push(i++);
                        } else { // If this bar is lower than top of stack, then calculate area of rectangle
                                // with stack top as the smallest (or minimum height) bar. 'i' is
                                // 'right index' for the top and element before top in stack is 'left index'
                                top = stack.pop();
                                // Calculate the area with heights[top] stack as smallest bar
                                area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                                // update max area, if needed
                                maxArea = Math.max(maxArea, area);
                        }
                }
                // Now pop the remaining bars from stack and calculate area with every
                // popped bar as the smallest bar
                while (!stack.isEmpty()) {
                        top = stack.pop();
                        // Calculate the area with heights[top] stack as smallest bar
                        area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                        // update max area, if needed
                        maxArea = Math.max(maxArea, area);
                }
                return maxArea;
        }
        
        public static void main(String[] args) {
                int heights[] = { 6, 2, 5, 4, 5, 1, 6 };
                System.out.println("Maximum area is = " + new LargestRectangleInHistogram().largestRectangleArea(heights, heights.length));
        }
}
