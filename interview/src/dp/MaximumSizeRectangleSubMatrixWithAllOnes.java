/**
 * Date 14/05/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(n)
 */
package dp;

import java.util.Stack;

public class MaximumSizeRectangleSubMatrixWithAllOnes {
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
        private int maxRectangle(int[][] matrix) {
                int m = matrix.length, n = matrix[0].length;
                // store the heights, by assuming as a histogram
                int[] heights = new int[n];
                int maxArea = Integer.MIN_VALUE;
                for (int i = 0; i < m; ++i) {
                        for (int j = 0; j < n; ++j) {
                                if (matrix[i][j] == 1) {
                                        heights[j]++;
                                } else {
                                        heights[j] = 0;
                                }
                        }
                        int area = largestRectangleArea(heights, n);
                        maxArea = Math.max(maxArea, area);
                }
                return maxArea;
        }
        public static void main(String[] args) {
                int[][] matrix = {
                        { 1, 0, 1, 0, 0 },
                        { 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 1, 0 }
                };
                System.out.print("Area of maximum rectangle is " + new MaximumSizeRectangleSubMatrixWithAllOnes().maxRectangle(matrix));
        }
}
