/**
 * https://leetcode.com/problems/two-sum/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
        private static int[] twoSum(int[] arr, int target) {
                // store result
                int[] result = new int[2];
                int n = arr.length;
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < n; ++i) {
                        // found
                        if (map.containsKey(target - arr[i])) {
                                result[0] = map.get(target - arr[i]);
                                result[1] = i;
                                return result;
                        }
                        map.put(arr[i], i);
                }
                return result;
        }
        public static void main(String[] args) {
                int arr[] = {2, 7, 11, 15};
                int target = 22;
                System.out.println(Arrays.toString(twoSum(arr, target)));
        }
}
