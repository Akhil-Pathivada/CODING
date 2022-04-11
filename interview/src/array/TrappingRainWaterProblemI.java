/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package array;

public class TrappingRainWaterProblemI {
        // get max of an element on its left side
        private static int maxElementOnLeft(int[] arr, int index) {
                
                int max = arr[index];
                for( ; index >= 0; --index) {
                        
                        if(arr[index] > max) {
                                max = arr[index];
                        }
                }
                return max;
        }
        // get max of an element on its right side
        private static int maxElementOnRight(int[] arr, int index) {
                
                int max = arr[index];
                for( ; index < arr.length; ++index) {
                        
                        if(arr[index] > max) {
                                max = arr[index];
                        }
                }
                return max;
        }
        
        private static int trap(int[] heights) {
                
                int n = heights.length;
                int water = 0; // store result
                
                for(int i = 0; i < n; ++i) {
                        // water can be hold on a bar = min of max heights on both sides
                        water += Math.min(maxElementOnLeft(heights, i), maxElementOnRight(heights, i)) - heights[i];
                }
                return water;
        }
        
        public static void main(String[] args) {
        
                int heights[] = {1, 0, 2, 0, 1, 0, 3, 1, 0, 2};
                System.out.println(trap(heights));
        }
}
