/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/rotate-array/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

import java.util.Arrays;

public class RotateArray {
        private void reverse(int[] nums, int left, int right) {
                while (left <= right) {
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        ++left; --right;
                }
        }
        private void rotateRight(int[] nums, int k, int n) {
                k = k % n;
                // if k == n
                if (k == 0) {
                        return;
                }
                // reverse entire array
                reverse(nums, 0, n - 1);
                // reverse first k elements
                reverse(nums, 0, k - 1);
                // reverse the remaining elements upto n
                reverse(nums, k, n - 1);
        }
        public static void main(String[] args) {
                int nums[] = { 1, 2, 3, 4, 5, 6, 7 }, k = 3;
                new RotateArray().rotateRight(nums, k, nums.length);
                System.out.println(Arrays.toString(nums));
        }
}
