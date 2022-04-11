/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class TrappingRainWaterProblemIII {
        
        private static int trap(int[] heights) {
                
                int n = heights.length;
                int leftMax, rightMax, low, high;
                int water = 0;
        
                leftMax = rightMax = 0;
                low = 0;
                high = n-1;
        
                while(low <= high) {
                
                        if(heights[low] < heights[high]) {
                        
                                if(heights[low] > leftMax) {
                                        leftMax = heights[low];
                                }
                                else {
                                        water += leftMax - heights[low];
                                }
                                ++low;
                        }
                        else {
                                if(heights[high] > rightMax) {
                                        rightMax = heights[high];
                                }
                                else {
                                        water += rightMax - heights[high];
                                }
                                --high;
                        }
                }
                return water;
        }
        
        public static void main(String[] args) {
                
                int heights[] = {1, 0, 2, 0, 1, 0, 3, 1, 0, 2};
                System.out.println(trap(heights));
        }
}
