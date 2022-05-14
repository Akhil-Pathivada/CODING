/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

import java.util.Arrays;

public class SquaresOfSortedArray {
        private int[] sortedSquares(int[] nums) {
                int n = nums.length;
                int left = 0, right = n - 1, i = n - 1;
                int[] result = new int[n];
                while (left <= right) {
                        if ((nums[left] * nums[left]) > (nums[right] * nums[right])) {
                                result[i--] = (nums[left] * nums[left]);
                                ++left;
                        } else {
                                result[i--] = (nums[right] * nums[right]);
                                --right;
                        }
                }
                return result;
        }
        public static void main(String[] args) {
                int[] nums = { -4, -1, 0, 3, 10 };
                System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(nums)));
        }
}
