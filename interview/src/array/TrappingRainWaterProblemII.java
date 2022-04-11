/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package array;

public class TrappingRainWaterProblemII {
        
        private static int trap(int[] heights) {
                
                int n = heights.length;
                int left[] = new int[n]; // stores left max of an element
                int right[] = new int[n]; // stores right max of an element
                // compute left max of every element
                left[0] = heights[0];
                for(int i = 1; i < n; ++i) {
                        left[i] = Math.max(left[i - 1], heights[i]);
                }
                // compute right max of every element
                right[n - 1] = heights[n - 1];
                for(int i = n - 2; i >= 0; --i) {
                        right[i] = Math.max(right[i + 1], heights[i]);
                }
                
                int water = 0; // store result
                // compute the result
                for(int i = 0; i < n; ++i) {
                        // water can be hold on a bar = min of max heights on both sides
                        water += Math.min(left[i], right[i]) - heights[i];
                }
                return water;
        }
        
        public static void main(String[] args) {
                
                int heights[] = {1, 0, 2, 0, 1, 0, 3, 1, 0, 2};
                System.out.println(trap(heights));
        }
}
