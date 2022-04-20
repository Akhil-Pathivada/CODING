/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 * */

package array;

public class ContainerWithMostWaterI {
        
        private static int maxArea(int[] height) {
                int n = height.length;
                int maxArea = 0;
                for(int i = 0; i < n; ++i) {
                        for(int j = i + 1; j < n; ++j) {
                                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                        }
                }
                return maxArea;
        }
        
        public static void main(String[] args) {
                int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7};
                System.out.println("Max. water can contains = " + maxArea(height));
        }
}
