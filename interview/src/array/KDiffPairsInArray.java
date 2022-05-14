/**
 * Date 14/05/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package array;

import java.util.HashMap;

public class KDiffPairsInArray {
        public int findPairs(int[] nums, int k) {
                int count = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; ++i) {
                        if (map.containsKey(nums[i] - k)) {
                                count += map.get(nums[i] - k);
                        } else if(map.containsKey(nums[i] + k)) {
                                map.put(nums[i] + k, 1);
                        }
                        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
                return count;
        }
        public static void main(String[] args) {
                int[] nums = { 3, 1, 4, 1, 5 };
                int k = 2;
                System.out.println(new KDiffPairsInArray().findPairs(nums, k));
        }
}
