/**
 * https://leetcode.com/problems/two-sum/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 * */
package hashing;

import java.util.Arrays;

public class TwoSumI {
        private static int[] twoSum(int[] arr, int target) {
                // store result
                int[] result = new int[2];
                int n = arr.length;
                for (int i = 0; i < n; ++i) {
                        for (int j = i + 1; j < n; ++j) {
                                // found
                                if (arr[i] + arr[j] == target) {
                                        result[0] = i;
                                        result[1] = j;
                                        return result;
                                }
                        }
                }
                return result;
        }
        public static void main(String[] args) {
                int arr[] = {2, 7, 11, 15};
                int target = 22;
                System.out.println(Arrays.toString(twoSum(arr, target)));
        }
}
