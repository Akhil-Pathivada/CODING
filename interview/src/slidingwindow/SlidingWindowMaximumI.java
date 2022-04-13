/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time Complexity : O(N * K)
 * Space Complexity : O(1)
 *
 */
package slidingwindow;

import java.util.*;

public class SlidingWindowMaximumI {
        
        private static int[] maxSlidingWindow(int[] nums, int k) {
                
                // store maximum of every window
                List<Integer> result = new ArrayList<>();
                for(int i = 0; i <= nums.length -k; ++i) {
                        // compute max in every window
                        int max = nums[i];
                        for(int j = i; j < i + k; ++j) {
                                max = Math.max(nums[j], max);
                        }
                        result.add(max);
                }
                return result.stream().mapToInt(e -> e).toArray();
        }
        
        public static void main(String[] args) {
                
                int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
                System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        }
}
