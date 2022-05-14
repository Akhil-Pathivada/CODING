/**
 * Date 31/03/2022
 *
 * @author akhilpathivada
 *
 * Given an unsorted array of integers, find a continous subarray which adds to a given number.
 *
 * (works for array with negative integers as well)
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package array;

import java.util.HashMap;

public class SubarraySumEqualsKIII {
        private void subarraySum(int[] nums, int k) {
                int n = nums.length, sum = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                for (int i = 0; i < n; ++i) {
                        sum += nums[i];
                        // found
                        if (map.containsKey(sum - k)) {
                                System.out.printf("Sum found between indices %d and %d ", map.get(sum - k) + 1, i);
                        }
                        map.put(sum, i);
                }
        }
        public static void main(String[] args) {
                int nums[] = { 1, 5, 20, 3, 10, 4}, k = 33;
                new SubarraySumEqualsKIII().subarraySum(nums, k);
        }
}
