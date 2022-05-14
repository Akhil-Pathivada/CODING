/**
 * Date 31/03/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package array;

import java.util.HashMap;

public class SubarraySumEqualsKIV {
        private int subarraySum(int[] nums, int k) {
                int sum = 0, result = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int num : nums) {
                        sum += num;
                        result += map.getOrDefault(sum - k, 0);
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
                return result;
        }
        public static void main(String[] args) {
                int nums[] = { 1, 5, 20, 3, 10, 4}, k = 33;
                System.out.printf("Total subarrays with sum K = %d ", new SubarraySumEqualsKIV().subarraySum(nums, k));
        }
}
