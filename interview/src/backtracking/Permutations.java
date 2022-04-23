/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/permutations/
 *
 * Time Complexity: O(n * n!)
 * Space Complexity : O(n)
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
        
        private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> ds) {
                // base case
                if (ds.size() == nums.length) {
                        result.add(new ArrayList<>(ds));
                } else {
                        for (int i = 0; i < nums.length; ++i) {
                                if (ds.contains(nums[i])) {
                                        continue;
                                }
                                ds.add(nums[i]);
                                backtrack(nums, result, ds);
                                ds.remove(ds.size() - 1);
                        }
                }
        }
        
        private List<List<Integer>> permute(int[] nums) {
                List<List<Integer>> result = new ArrayList<>();
                backtrack(nums, result, new ArrayList<>());
                return result;
        }
        
        public static void main(String[] args) {
                int[] nums = { 1, 2, 3 };
                System.out.println(new Permutations().permute(nums));
        }
}
